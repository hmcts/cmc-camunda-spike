package com.cmc.camunda.process.process;

import com.google.gson.Gson;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class ProcessCreateTask {
    public static void main(String[] args) {

        String baseUrl = "http://localhost:8999/rest/process-definition/key/d217a915-dae6-11e9-ba33-0242ac130003/start";
        String baseUrlTenant = "http://localhost:8999/rest/process-definition/key/JudgmentProcess/tenant-id/cmc/start";
        String processKey = "JudgmentProcess";
        RestTemplate restTemplate = new RestTemplate();

        HashMap<String, ProcessVariable> variable = new HashMap<>();
        variable.put("caseId", new ProcessVariable("caseID401", "String"));

        CreateMessage createMessage = new CreateMessage("process201", "businessKey", variable );
        Gson gson = new Gson();
        System.out.println(gson.toJson(createMessage));
        try {
            restTemplate.postForObject(baseUrlTenant, createMessage, Object.class);
        }catch (Exception gene){
            gene.printStackTrace();
        }
    }
}
