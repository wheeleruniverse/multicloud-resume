
provider "aws" {
  region = "us-east-1"
}

locals {
  aws_fqdn_list = [
    "aws.${var.fqdn}",
    var.fqdn,
    "www.${var.fqdn}"
  ]
}

resource "aws_acm_certificate" "this" {
  domain_name               = var.fqdn
  subject_alternative_names = local.aws_fqdn_list
  tags                      = local.tags
  validation_method         = "DNS"

  lifecycle {
    create_before_destroy = true
  }
}

resource "aws_cloudfront_distribution" "this" {
  aliases             = local.aws_fqdn_list
  enabled             = true
  comment             = "${var.domain} distribution"
  default_root_object = "index.html"
  is_ipv6_enabled     = true
  price_class         = "PriceClass_100"
  tags                = local.tags

  default_cache_behavior {
    allowed_methods = [
      "DELETE",
      "GET",
      "HEAD",
      "OPTIONS",
      "PATCH",
      "POST",
      "PUT"
    ]
    cached_methods = [
      "GET",
      "HEAD"
    ]
    compress               = true
    target_origin_id       = aws_s3_bucket.web.id
    viewer_protocol_policy = "redirect-to-https"

    forwarded_values {
      query_string = false

      cookies {
        forward = "none"
      }
    }
  }
  origin {
    domain_name = aws_s3_bucket.web.bucket_regional_domain_name
    origin_id   = aws_s3_bucket.web.id

    s3_origin_config {
      origin_access_identity = aws_cloudfront_origin_access_identity.this.cloudfront_access_identity_path
    }
  }
  restrictions {
    geo_restriction {
      restriction_type = "none"
    }
  }
  viewer_certificate {
    acm_certificate_arn            = aws_acm_certificate.this.arn
    cloudfront_default_certificate = false
    minimum_protocol_version       = "TLSv1.2_2021"
    ssl_support_method             = "sni-only"
  }
}

resource "aws_cloudfront_origin_access_identity" "this" {
  comment = "${var.domain} oai"
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