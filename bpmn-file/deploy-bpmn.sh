#!/bin/bash

set -e

#CAMUNDA_URI="http://localhost:8999"
CAMUNDA_URI="http://camunda-bpm-pr-8.service.core-compute-preview.internal"

curl -F deployment-name=cmc-deployment-v2 -F deploy-changed-only=true \
     -F deployment-source=automated -F data=@timer-v2.bpmn \
     -F tenant-id=cmc ${CAMUNDA_URI}/rest/deployment/create

echo -e "\nDeployment Done."
