#!/usr/bin/env bash

CHART="cmc-camunda-spike"
RELEASE="cmc-camunda-spike-release"
NAMESPACE="money-claims"

helm install ${CHART} --name ${RELEASE} \
  --namespace ${NAMESPACE} \
  -f ci-values.yaml --wait --timeout 160

