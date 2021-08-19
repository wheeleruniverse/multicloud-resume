#!/bin/bash

echo "copy-assets.sh begin @ $(date)"

LOCAL="copy-assets-tmp"
rm -rf ${LOCAL}
mkdir ${LOCAL}

BUCKET="wheelercloudguru-iac"
aws s3 cp "s3://${BUCKET}" ${LOCAL} --only-show-errors --recursive

# TODO: Upload ${LOCAL} to Azure wheelercloudguruiac ${BUCKET//-/}

# TODO: Upload ${LOCAL} to GCP wheelercloudguru-iac

rm -rf ${LOCAL}
echo "copy-assets.sh ended @ $(date)"
