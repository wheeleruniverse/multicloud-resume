
provider "aws" {
  region = "us-east-1"
}

resource "aws_s3_bucket" "app" {
  acl    = "private"
  bucket = "${var.domain}-app"
  tags   = local.tags
}

resource "aws_s3_bucket" "iac" {
  acl    = "public-read"
  bucket = "${var.domain}-iac"
  tags   = local.tags
}

resource "aws_s3_bucket" "web" {
  acl    = "private"
  bucket = "${var.domain}-web"
  tags   = local.tags
}