package com.cmc.camunda.external.service;

import com.cmc.camunda.external.service.domain.JudgmentRequest;
import com.cmc.camunda.model.StartResponse;
import com.cmc.camunda.process.process.CreateMessage;
import com.cmc.camunda.process.process.ProcessVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Component
public class CCDClient {

    private final RestTemplate restTemplate;
    private final String updateJudgmentUrl;

    @Autowired
    public CCDClient(@Value("${ccd.url}") String baseUrl, RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
        this.updateJudgmentUrl = baseUrl + "/support/updateJudgment";
    }

    public void updateJudgment(Long caseId, String judgmentProcessId) {
        JudgmentRequest judgmentRequest = new JudgmentRequest(caseId, judgmentProcessId);
        Object obj = restTemplate.postForObject(updateJudgmentUrl, judgmentRequest, Object.class);
    }
}
