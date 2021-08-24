
provider "google" {
  project = "wheeler-resume"
  region  = "us-central1"
}

variable "gcp_bucket_replication" {
  default     = "US"
  description = "bucket replication"
  type        = string
}

variable "gcp_bucket_tier" {
  default     = "STANDARD"
  description = "bucket tier"
  type        = string
}

resource "google_storage_bucket" "app" {
  name = "${var.domain}-app"
  labels = {
    environment = var.environment
    owner       = var.owner
    project     = var.project
  }
  location      = var.gcp_bucket_replication
  storage_class = var.gcp_bucket_tier
}

resource "google_storage_bucket" "iac" {
  name = "${var.domain}-iac"
  labels = {
    environment = var.environment
    owner       = var.owner
    project     = var.project
  }
  location      = var.gcp_bucket_replication
  storage_class = var.gcp_bucket_tier
}

resource "google_storage_bucket" "web" {
  name = "${var.domain}-web"
  labels = {
    environment = var.environment
    owner       = var.owner
    project     = var.project
  }
  location      = var.gcp_bucket_replication
  storage_class = var.gcp_bucket_tier
}