#!/usr/bin/env bash

CHART="cmc-camunda-spike"
RELEASE="cmc-camunda-spike-release"
NAMESPACE="money-claims"

helm upgrade ${RELEASE} ${CHART}  \
  -f ci-values.yaml \
  --wait --timeout 160 \
  --namespace ${NAMESPACE}

