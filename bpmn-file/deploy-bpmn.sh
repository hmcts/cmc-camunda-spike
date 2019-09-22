#!/bin/bash

set -e

CAMUNDA_URI="http://localhost:8999"

curl -F deployment-name=cmc-depl-02 -F deploy-changed-only=true \
     -F deployment-source=automated -F data=@timer2.bpmn \
     -F tenant-id=cmc ${CAMUNDA_URI}/rest/deployment/create

echo -e "\nDeployment Done."
