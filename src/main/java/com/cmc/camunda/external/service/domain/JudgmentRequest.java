package com.cmc.camunda.external.service.domain;


public class JudgmentRequest {

    public Long getCaseId() {
        return caseId;
    }

    public String getJusgmentProcessId() {
        return jusgmentProcessId;
    }

    private Long caseId;
    private String jusgmentProcessId;

    public JudgmentRequest(Long caseId, String jusgmentProcessId) {
        this.caseId = caseId;
        this.jusgmentProcessId = jusgmentProcessId;
    }
}