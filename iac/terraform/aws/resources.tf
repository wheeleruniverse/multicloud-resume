
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
    acm_certificate_arn            = "arn:aws:acm:us-east-1:778263278211:certificate/5bed8c4a-fb53-4a2e-800d-64740eaf6c7b"
    cloudfront_default_certificate = false
    minimum_protocol_version       = var.tls_version
    ssl_support_method             = "sni-only"
  }
}

resource "aws_cloudfront_origin_access_identity" "this" {
  comment = "${var.domain} oai"
}

resource "aws_codeartifact_domain" "this" {
  domain = var.domain
  tags   = local.tags
}

resource "aws_codeartifact_repository" "this" {
  domain     = aws_codeartifact_domain.this.domain
  repository = var.project
  tags       = local.tags
}

resource "aws_codeartifact_repository_permissions_policy" "this" {
  domain          = aws_codeartifact_domain.this.domain
  repository      = aws_codeartifact_repository.this.repository
  policy_document = <<EOF
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": [
                "codeartifact:DescribePackageVersion",
                "codeartifact:DescribeRepository",
                "codeartifact:GetPackageVersionReadme",
                "codeartifact:GetRepositoryEndpoint",
                "codeartifact:ListPackageVersionAssets",
                "codeartifact:ListPackageVersionDependencies",
                "codeartifact:ListPackageVersions",
                "codeartifact:ListPackages",
                "codeartifact:ReadFromRepository"
            ],
            "Effect": "Allow",
            "Principal": "*",
            "Resource": "${aws_codeartifact_repository.this.arn}"
        }
    ]
}
EOF
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
