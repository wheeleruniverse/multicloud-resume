
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

variable "tables" {
  default     = ["certification", "education", "experience", "project", "skill", "visitor"]
  description = "sql tables to create"
  type        = list(string)
}

resource "azurerm_application_insights" "insights" {
  application_type    = "java"
  location            = azurerm_resource_group.rg.location
  name                = "${var.prefix}insights"
  resource_group_name = azurerm_resource_group.rg.name
  retention_in_days   = 30
  sampling_percentage = 1
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

resource "azurerm_cdn_endpoint" "web_origin" {
  location            = azurerm_resource_group.rg.location
  name                = "${azurerm_storage_account.sa_web.name}-cdn"
  origin_host_header  = "${azurerm_storage_account.sa_web.name}.z20.web.core.windows.net"
  profile_name        = azurerm_cdn_profile.web_cdn.name
  resource_group_name = azurerm_resource_group.rg.name
  tags = {
    Project = var.project
  }

  delivery_rule {
    name  = "HttpToHttpsRedirect"
    order = 1

    request_scheme_condition {
      match_values = ["HTTP"]
      operator     = "Equal"
    }
    url_redirect_action {
      protocol      = "Https"
      redirect_type = "PermanentRedirect"
    }
  }

  origin {
    host_name = "${azurerm_storage_account.sa_web.name}.z20.web.core.windows.net"
    name      = "${azurerm_storage_account.sa_web.name}-cdn"
  }
}

resource "azurerm_cdn_profile" "web_cdn" {
  location            = azurerm_resource_group.rg.location
  name                = "${var.prefix}cdn"
  resource_group_name = azurerm_resource_group.rg.name
  sku                 = "Standard_Microsoft"
  tags = {
    Project = var.project
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
  partition_key_path  = "/id"
  resource_group_name = azurerm_resource_group.rg.name
}

resource "azurerm_cosmosdb_sql_database" "prd" {
  account_name        = azurerm_cosmosdb_account.db.name
  name                = "prd"
  resource_group_name = azurerm_resource_group.rg.name
}

resource "azurerm_function_app" "app" {
  app_service_plan_id = azurerm_app_service_plan.asp.id
  app_settings = {
    APPINSIGHTS_INSTRUMENTATIONKEY = azurerm_application_insights.insights.instrumentation_key
    COSMOS_AUTH                    = azurerm_cosmosdb_account.db.primary_master_key
    COSMOS_HOST                    = azurerm_cosmosdb_account.db.endpoint
    COSMOS_NAME                    = azurerm_cosmosdb_sql_database.prd.name
    FUNCTIONS_WORKER_RUNTIME       = "java"
    FUNCTION_APP_EDIT_MODE         = "readonly"
    FUNCTIONS_EXTENSION_VERSION    = "~3"
    WEBSITE_RUN_FROM_PACKAGE       = "1"
  }
  https_only                 = true
  location                   = azurerm_resource_group.rg.location
  name                       = "${var.prefix}app"
  resource_group_name        = azurerm_resource_group.rg.name
  storage_account_access_key = azurerm_storage_account.sa_app.primary_access_key
  storage_account_name       = azurerm_storage_account.sa_app.name
  version                    = "~3"
  tags = {
    Project = var.project
  }

  site_config {
    java_version = "11"

    cors {
      allowed_origins     = ["*"]
      support_credentials = false
    }
  }
}

resource "azurerm_resource_group" "rg" {
  location = "East US 2"
  name     = var.project
  tags = {
    Project = var.project
  }
}

resource "azurerm_storage_account" "sa_app" {
  account_replication_type = "LRS"
  account_tier             = "Standard"
  location                 = azurerm_resource_group.rg.location
  name                     = "${replace(var.prefix, "-", "")}app"
  resource_group_name      = azurerm_resource_group.rg.name
}

resource "azurerm_storage_account" "sa_web" {
  account_replication_type = "LRS"
  account_tier             = "Standard"
  location                 = azurerm_resource_group.rg.location
  name                     = "${replace(var.prefix, "-", "")}web"
  resource_group_name      = azurerm_resource_group.rg.name

  static_website {
    index_document = "index.html"
  }
}
