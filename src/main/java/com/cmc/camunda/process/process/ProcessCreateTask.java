package com.cmc.camunda.process.process;

import com.cmc.camunda.model.StartResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Component
public class ProcessCreateTask {

    private final String processStartUrl;
    private final RestTemplate restTemplate;
    private final String processKey = "JudgmentProcess";

    @Autowired
    public ProcessCreateTask(@Value("${camunda.base.url}") String baseUrl,
                             @Value("${camunda.tenant}") String tenantId, RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
        this.processStartUrl = baseUrl + "/process-definition/key/" + processKey + "/tenant-id/" + tenantId + "/start";
    }

    public String createProcess(String caseId) {

        String messageKey = "JUDGMENT-PROCESS-" + caseId;
        HashMap<String, ProcessVariable> variable = new HashMap<>();
        variable.put("caseId", new ProcessVariable(caseId, "String"));

        CreateMessage createMessage = new CreateMessage("process201", messageKey, variable );
        StartResponse response = restTemplate.postForObject(processStartUrl, createMessage, StartResponse.class);
        return response.getId();
    }
}
