package com.cmc.camunda.external.task;

import org.camunda.bpm.client.ExternalTaskClient;
import org.camunda.bpm.client.backoff.ExponentialBackoffStrategy;
import org.camunda.bpm.client.topic.TopicSubscriptionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JudgmentExternalTaskListener {

    private String baseUrl = "http://localhost:8999/rest";
    private String topicName = "CMC_Judgment";
    private ExternalTaskClient client;
    private TopicSubscriptionBuilder subscriptionBuilder;

    @Autowired
    public JudgmentExternalTaskListener(JudgmentTaskHandler taskHandler) {
        client = ExternalTaskClient.create()
                .baseUrl(baseUrl)
                .lockDuration(6000)
                .backoffStrategy(new ExponentialBackoffStrategy(500L, 2, 30000L))
                .maxTasks(2)
                .build();
        subscriptionBuilder = client.subscribe(topicName)
                .variables("caseId")
                .tenantIdIn("cmc");
        subscriptionBuilder.handler(taskHandler)
                .tenantIdIn("cmc")
                .open();
    }

}



