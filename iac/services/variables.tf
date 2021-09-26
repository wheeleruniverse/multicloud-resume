
locals {
  // order matters to avoid re-creation
  services = [
    "domains",
    "dns",
    "compute",
    "containerregistry",
    "run",
    "sourcerepo",
    "cloudbuild"
  ]

  timeout = "60m"
}

variable "domain" {
  default     = "wheelersadvice"
  description = "domain name"
  type        = string
}

variable "location_region" {
  default     = "US-CENTRAL1"
  description = "a specific geographic place, such as São Paulo"
  type        = string

  validation {
    condition     = contains(["US-CENTRAL1", "US-EAST1", "US-EAST4", "US-WEST1", "US-WEST2", "US-WEST3", "US-WEST4"], var.location_region)
    error_message = "Variable location_region is invalid."
  }
}

variable "project" {
  default     = "cloudguruchallenge-2108"
  description = "project name"
  type        = string
}
