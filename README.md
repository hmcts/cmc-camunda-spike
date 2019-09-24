# cmc-camunda-spike

A microservice to listen to Camunda Topic for when BPMN timer quicks in.
It has a chart for deploying the microservice together with Camunda Engine to Preview AKS. 

## Docker image

To build Docker image please run:

```bash
$ docker build --tag hmctspublic.azurecr.io/cmc/camunda-spike:latest .
```
