
terraform {
  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
      version = ">= 2.26"
    }
  }

  required_version = ">= 0.14.9"
}

provider "azurerm" {
  features {}
}

variable "prefix" {
  default     = "wheeler-resume-"
  description = "prefix name"
  type        = string
}

variable "project" {
  default     = "CloudGuruChallenge_21.04"
  description = "project name"
  type        = string
}

variable "query_func_dst" {
  default     = "query-func.zip"
  description = "query function code destination"
  type        = string
}

variable "query_func_src" {
  default     = "./code/query-func.zip"
  description = "query function code source"
  type        = string
}

variable "tables" {
  default     = ["certification", "education", "experience", "project", "skill", "visitor"]
  description = "sql tables to create"
  type        = list(string)
}

data "azurerm_storage_account_sas" "sas" {
  connection_string = azurerm_storage_account.sa.primary_connection_string
  expiry            = "2021-06-01"
  https_only        = true
  start             = "2021-05-01"

  resource_types {
    container = false
    object    = true
    service   = false
  }
  permissions {
    add     = false
    create  = false
    delete  = false
    list    = false
    process = false
    read    = true
    update  = false
    write   = false
  }
  services {
    blob  = true
    file  = false
    queue = false
    table = false
  }
}

resource "azurerm_application_insights" "insights" {
  application_type    = "java"
  location            = azurerm_resource_group.rg.location
  name                = "${var.prefix}insights"
  resource_group_name = azurerm_resource_group.rg.name
  retention_in_days   = 30
  tags = {
    Project = var.project
  }
}

resource "azurerm_app_service_plan" "asp" {
  kind                = "FunctionApp"
  location            = azurerm_resource_group.rg.location
  name                = "${var.prefix}asp"
  resource_group_name = azurerm_resource_group.rg.name
  tags = {
    Project = var.project
  }

  sku {
    size = "Y1"
    tier = "Dynamic"
  }
}

resource "azurerm_cosmosdb_account" "db" {
  enable_automatic_failover = false
  enable_free_tier          = true
  kind                      = "GlobalDocumentDB"
  location                  = azurerm_resource_group.rg.location
  name                      = "${var.prefix}cosmos-db"
  offer_type                = "Standard"
  resource_group_name       = azurerm_resource_group.rg.name
  tags = {
    Project = var.project
  }

  capabilities {
    name = "EnableServerless"
  }
  consistency_policy {
    consistency_level = "Eventual"
  }
  geo_location {
    failover_priority = 0
    location          = azurerm_resource_group.rg.location
  }
}

resource "azurerm_cosmosdb_sql_container" "tables" {
  account_name        = azurerm_cosmosdb_account.db.name
  count               = length(var.tables)
  database_name       = azurerm_cosmosdb_sql_database.prd.name
  name                = var.tables[count.index]
  resource_group_name = azurerm_resource_group.rg.name
}

resource "azurerm_cosmosdb_sql_database" "prd" {
  account_name        = azurerm_cosmosdb_account.db.name
  name                = "prd"
  resource_group_name = azurerm_resource_group.rg.name
}

resource "azurerm_function_app" "query_func" {
  app_service_plan_id        = azurerm_app_service_plan.asp.id
  https_only                 = true
  location                   = azurerm_resource_group.rg.location
  name                       = "${var.prefix}query-func"
  resource_group_name        = azurerm_resource_group.rg.name
  storage_account_access_key = azurerm_storage_account.sa.primary_access_key
  storage_account_name       = azurerm_storage_account.sa.name
  tags = {
    Project = var.project
  }

  app_settings = {
    APPINSIGHTS_INSTRUMENTATIONKEY = azurerm_application_insights.insights.instrumentation_key
    FUNCTIONS_WORKER_RUNTIME       = "java"
    FUNCTION_APP_EDIT_MODE         = "readonly"
    FUNCTIONS_EXTENSION_VERSION    = "~3"
    HASH                           = base64encode(filesha256(var.query_func_src))
    WEBSITE_RUN_FROM_PACKAGE       = "1"
  }
}

resource "azurerm_resource_group" "rg" {
  location = "East US 2"
  name     = var.project
  tags = {
    Project = var.project
  }
}

resource "azurerm_storage_account" "sa" {
  account_replication_type = "LRS"
  account_tier             = "Standard"
  location                 = azurerm_resource_group.rg.location
  name                     = replace(var.prefix, "-", "")
  resource_group_name      = azurerm_resource_group.rg.name
}

resource "azurerm_storage_blob" "query_func_code" {
  name                   = var.query_func_dst
  source                 = var.query_func_src
  storage_account_name   = azurerm_storage_account.sa.name
  storage_container_name = azurerm_storage_container.deployments.name
  type                   = "Block"
}

resource "azurerm_storage_container" "deployments" {
  container_access_type = "private"
  name                  = "deployments"
  storage_account_name  = azurerm_storage_account.sa.name
}
