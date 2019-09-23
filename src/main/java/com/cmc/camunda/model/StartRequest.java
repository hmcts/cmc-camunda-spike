package com.cmc.camunda.model;

public class StartRequest {
    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    private String caseId;
}
