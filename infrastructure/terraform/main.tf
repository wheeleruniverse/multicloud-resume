
terraform {
  required_version = ">= 0.14.9"

  backend "remote" {
    hostname     = "app.terraform.io"
    organization = "wheelers-websites"

    workspaces {
      name = "Resume"
    }
  }
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = ">= 3.55.0"
    }
    azurerm = {
      source  = "hashicorp/azurerm"
      version = ">= 2.73.0"
    }
    google = {
      source  = "hashicorp/google"
      version = ">= 3.80.0"
    }
  }
}

variable "domain" {
  default     = "wheelercloudguru"
  description = "domain name"
  type        = string
}

variable "environment" {
  default     = "prd"
  description = "environment name"
  type        = string
}

variable "fqdn" {
  default     = "wheelercloudguru.com"
  description = "fully qualified domain name"
  type        = string
}

variable "owner" {
  default     = "justin.wheeler@wheelerswebsites.com"
  description = "owner email address"
  type        = string
}

variable "project" {
  default     = "resume"
  description = "project name"
  type        = string
}

variable "tables" {
  default     = ["certification", "education", "experience", "project", "skill", "visitor"]
  description = "sql tables to create"
  type        = list(string)
}

variable "tls_version" {
  default     = "TLS1_2"
  description = "tls version"
  type        = string
}
