
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
  name                        = "${var.domain}-app"
  force_destroy               = true
  labels                      = local.labels
  location                    = var.gcp_bucket_replication
  storage_class               = var.gcp_bucket_tier
  uniform_bucket_level_access = true
}

resource "google_storage_bucket" "iac" {
  name                        = "${var.domain}-iac"
  force_destroy               = true
  labels                      = local.labels
  location                    = var.gcp_bucket_replication
  storage_class               = var.gcp_bucket_tier
  uniform_bucket_level_access = true
}

resource "google_storage_bucket" "web" {
  name                        = "${var.domain}-web"
  force_destroy               = true
  labels                      = local.labels
  location                    = var.gcp_bucket_replication
  storage_class               = var.gcp_bucket_tier
  uniform_bucket_level_access = true
}