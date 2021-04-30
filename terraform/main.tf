
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

variable "project" {
  default     = "CloudGuruChallenge_21.04"
  description = "project name"
  type        = string
}

variable "tables" {
  default     = ["certification", "education", "experience", "project", "skill"]
  description = "sql tables to create"
  type        = list(string)
}

resource "azurerm_resource_group" "rg" {
  name     = "CloudGuruChallenge_21.04"
  location = "East US 2"

  tags = {
    Project = var.project
  }
}

resource "azurerm_cosmosdb_account" "cosmos_account" {
  name                      = "resume-cosmos-db"
  resource_group_name       = azurerm_resource_group.rg.name
  enable_automatic_failover = false
  enable_free_tier          = true
  kind                      = "GlobalDocumentDB"
  location                  = azurerm_resource_group.rg.location
  offer_type                = "Standard"

  capabilities {
    name = "EnableServerless"
  }

  consistency_policy {
    consistency_level = "Eventual"
  }

  geo_location {
    location          = azurerm_resource_group.rg.location
    failover_priority = 0
  }

  tags = {
    Project = var.project
  }
}

resource "azurerm_cosmosdb_sql_database" "cosmos_database_prd" {
  name                = "prd"
  resource_group_name = azurerm_resource_group.rg.name
  account_name        = azurerm_cosmosdb_account.cosmos_account.name
}

resource "azurerm_cosmosdb_sql_container" "cosmos_tables" {
  count               = length(var.tables)
  name                = var.tables[count.index]
  resource_group_name = azurerm_resource_group.rg.name
  account_name        = azurerm_cosmosdb_account.cosmos_account.name
  database_name       = azurerm_cosmosdb_sql_database.cosmos_database_prd.name
}
