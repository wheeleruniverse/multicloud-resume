#!/bin/bash

function create_directory(){
	rm -rf ${1}
	mkdir ${1}
}

echo "copy-assets.sh begin @ $(date)"

LOCAL_DIR="copy-assets-tmp"
create_directory ${LOCAL_DIR}

BUCKET="wheelercloudguru-iac"
aws s3 cp "s3://${BUCKET}" ${LOCAL_DIR} \
--only-show-errors \
--recursive 

az storage blob upload-batch \
--account-name ${BUCKET//-/} \
--destination web \
--no-progress \
--only-show-errors \
--output none \
--source ${LOCAL_DIR}/web

# https://wheelercloudguruiac.blob.core.windows.net/web/certification/0f6d8e2f-4ba4-4705-a483-2de7b71bf397/badge.png
# https://wheelercloudguruiac.blob.core.windows.net/web/certification/0f6d8e2f-4ba4-4705-a483-2de7b71bf397/credential.pdf

# TODO: Upload ${LOCAL_DIR} to GCP wheelercloudguru-iac

rm -rf ${LOCAL_DIR}
echo "copy-assets.sh ended @ $(date)"
