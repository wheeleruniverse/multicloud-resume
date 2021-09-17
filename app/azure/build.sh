#!/bin/bash

echo "$(date) :: started"

echo
echo "$(date) :: aws codeartifact get-authorization-token"
export ARTIFACTS_AUTH=$(aws codeartifact get-authorization-token \
--domain wheelercloudguru \
--query authorizationToken \
--output text)

echo
echo "$(date) :: mvn package"
mvn package
if [[ "$?" -ne 0 ]] ; then
  echo
  echo "$(date) :: mvn package failed"
  exit 1
fi

echo
echo "$(date) :: success"
