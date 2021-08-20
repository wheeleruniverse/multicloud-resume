
terraform {
  required_version = ">= 0.14.9"

  backend "remote" {
    hostname     = "app.terraform.io"
    organization = "wheelers-websites"

    workspaces {
      name = "Resume"
    }
  }
}

variable "bucket" {
  default     = "wheelercloudguru-iac"
  description = "infrastructure bucket name on aws s3"
  type        = string
}

variable "prefix" {
  default     = "wheeler-resume-"
  description = "prefix name"
  type        = string
}

variable "project" {
  default     = "Resume"
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
