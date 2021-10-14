#!/bin/bash

if [ $# -eq 0 ]; then
	echo 
    echo "error: please provide the entity name"
	echo 
    exit 1
fi

NAME="load-json.sh"
JSON="@../data/json/${1}.json"

echo "${NAME} :: $(date) :: Started"

echo 
echo "${NAME} :: $(date) :: With Source '${JSON}'"

echo
echo "${NAME} :: $(date) :: Load AWS"
#curl -s -X POST -H "Content-Type: application/json" -d ${JSON} \
#"http://localhost:9999/${1}/load"

echo 
echo "${NAME} :: $(date) :: Load Azure"
curl -s -X POST -H "Content-Type: application/json" -d ${JSON} \
"https://wheelercloudguru.azurewebsites.net/api/${1}/load"

echo
echo "${NAME} :: $(date) :: Load GCP"
curl -s -X POST -H "Content-Type: application/json" -d ${JSON} \
"https://api.gcp.wheelercloudguru.com/${1}/load"

echo 
echo "${NAME} :: $(date) :: Success"
