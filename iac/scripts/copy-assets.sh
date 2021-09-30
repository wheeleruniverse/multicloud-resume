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

az storage blob sync \
--account-name ${BUCKET//-/} \
--container 'web' \
--only-show-errors \
--output none \
--source ${LOCAL_DIR}/web/

gsutil -m -q rsync -d -r ${LOCAL_DIR}/ "gs://${BUCKET}"

rm -rf ${LOCAL_DIR}
echo "copy-assets.sh ended @ $(date)"
