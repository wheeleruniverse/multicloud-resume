
locals {
  aws_fqdn_list = [
    "aws.${var.fqdn}",
    var.fqdn,
    "www.${var.fqdn}"
  ]
  labels = {
    environment = var.environment
    project     = var.project
  }
  tags = {
    environment = var.environment
    owner       = var.owner
    project     = var.project
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
