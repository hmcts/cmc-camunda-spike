#!/usr/bin/env bash

helm upgrade cmc-camunda-spike-test cmc-camunda-spike \
  -f ci-values.yaml \
  --install --wait --timeout 900 \
  --namespace money-claims
