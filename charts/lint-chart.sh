#!/usr/bin/env bash

CHART="cmc-camunda-spike"
NAMESPACE="money-claims"

helm lint ${CHART}  \
  -f ci-values.yaml \
  --namespace ${NAMESPACE}


