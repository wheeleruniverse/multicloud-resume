#!/bin/bash

echo "$(date) :: Begin"
echo "$(date) :: aws codeartifact get-authorization-token"
echo
export ARTIFACTS_AUTH=$(aws codeartifact get-authorization-token \
--domain wheelercloudguru \
--query authorizationToken \
--output text)

echo "$(date) :: mvn deploy"
echo
mvn deploy

echo "$(date) :: Ended"
