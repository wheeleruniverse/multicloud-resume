#!/bin/bash

echo "$(date) :: started"

echo
echo "$(date) :: aws codeartifact get-authorization-token"
export ARTIFACTS_AUTH=$(aws codeartifact get-authorization-token \
--domain wheelercloudguru \
--query authorizationToken \
--output text)

echo
echo "$(date) :: mvn test"
mvn test
if [[ "$?" -ne 0 ]] ; then
  echo
  echo "$(date) :: mvn test failed"
  exit 1
fi

echo
echo "$(date) :: mvn deploy"
mvn deploy
if [[ "$?" -ne 0 ]] ; then
  echo
  echo "$(date) :: mvn deploy failed"
  exit 1
fi

echo
echo "$(date) :: success"
