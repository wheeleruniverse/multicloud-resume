#!/bin/bash

echo "$(date) :: started"
echo "$(date) :: aws codeartifact get-authorization-token"
echo
export ARTIFACTS_AUTH=$(aws codeartifact get-authorization-token \
--domain wheelercloudguru \
--query authorizationToken \
--output text)

echo "$(date) :: mvn deploy"
echo
mvn deploy
if [[ "$?" -ne 0 ]] ; then
  echo "$(date) :: mvn deploy failed"
  exit 1
fi

echo "$(date) :: success"
