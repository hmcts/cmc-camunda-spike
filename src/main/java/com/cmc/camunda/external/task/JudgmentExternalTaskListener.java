package com.cmc.camunda.external.task;

import org.camunda.bpm.client.ExternalTaskClient;
import org.camunda.bpm.client.topic.TopicSubscriptionBuilder;

import java.util.HashMap;
import java.util.Map;

public class JudgmentExternalTaskListener {
    public static void main(String[] args) {

        String baseUrl = "http://localhost:8999/api/engine";
        String topicName = "CMC_Judgment";
        String judgementRequired = "true";

        ExternalTaskClient client = ExternalTaskClient.create()
                .baseUrl(baseUrl)
                .lockDuration(6000)
                .maxTasks(2)
                .build();

        TopicSubscriptionBuilder subscriptionBuilder = client.subscribe(topicName);

        subscriptionBuilder.handler(((externalTask, externalTaskService) -> {

            try {
                String caseId = externalTask.getVariable("caseId");
                System.out.println("The Case ID working on is ....." + caseId);


                Map<String, Object> variablesToBeSupplied = new HashMap<>();
                variablesToBeSupplied.put("paperResponsePresent", judgementRequired);
                externalTaskService.complete(externalTask, variablesToBeSupplied);
            }catch (Exception gene){
                System.out.println("EXCEPTION>>>>>>" + gene.getMessage());
                gene.printStackTrace();
            }
        })).open();

    }
}
