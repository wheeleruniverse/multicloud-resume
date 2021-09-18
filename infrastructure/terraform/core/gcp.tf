
provider "google" {
  project = local.gcp_project
  region  = "us-central1"
}

locals {
  gcp_project = "wheeler-resume"
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

variable "gcp_image" {
  description = "container image"
  type        = string
}

variable "gcp_svc_json" {
  description = "service account json"
  type        = string
}

resource "google_app_engine_application" "this" {
  database_type = "CLOUD_FIRESTORE"
  location_id   = "us-central"
}

resource "google_cloud_run_domain_mapping" "this" {
  location = google_cloud_run_service.this.location
  name     = "api.gcp.${var.fqdn}"

  metadata {
    labels    = local.labels
    namespace = local.gcp_project
  }
  spec {
    route_name = google_cloud_run_service.this.name
  }
}

resource "google_cloud_run_service" "this" {
  autogenerate_revision_name = true
  location                   = "us-central1"
  name                       = var.domain

  template {
    metadata {
      labels = local.labels
    }
    spec {
      containers {
        image = var.gcp_image

        env {
          name  = "GCP_CREDENTIALS"
          value = var.gcp_svc_json
        }
      }
    }
  }
  traffic {
    latest_revision = true
    percent         = 100
  }
}

resource "google_compute_backend_bucket" "this" {
  bucket_name = google_storage_bucket.web.name
  enable_cdn  = true
  name        = google_storage_bucket.web.name
}

resource "google_compute_global_forwarding_rule" "this" {
  name       = var.domain
  target     = google_compute_target_https_proxy.this.id
  port_range = "443"
}

resource "google_compute_managed_ssl_certificate" "this" {
  name = var.domain

  managed {
    domains = [
      "gcp.${var.fqdn}.",
      "www.${var.fqdn}."
    ]
  }
}

resource "google_compute_target_https_proxy" "this" {
  name             = var.domain
  ssl_certificates = [google_compute_managed_ssl_certificate.this.id]
  url_map          = google_compute_url_map.this.id
}

resource "google_compute_url_map" "this" {
  default_service = google_compute_backend_bucket.this.id
  name            = var.domain
}

resource "google_container_registry" "this" {
  location = "US"
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

  website {
    main_page_suffix = "index.html"
  }
}
