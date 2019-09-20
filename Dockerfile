FROM hmctspublic.azurecr.io/base/java:openjdk-8-distroless-1.0

LABEL maintainer="https://github.com/hmcts/cmc-camunda-spike"

COPY build/libs/cmc-camunda-spike-1.0-SNAPSHOT.jar /opt/app/

EXPOSE 4401
CMD [ "cmc-camunda-spike-1.0-SNAPSHOT.jar" ]
