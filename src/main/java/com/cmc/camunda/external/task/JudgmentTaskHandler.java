package com.cmc.camunda.external.task;

import com.cmc.camunda.external.service.CCDClient;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JudgmentTaskHandler implements ExternalTaskHandler {

    private static final Logger logger = LoggerFactory.getLogger(JudgmentTaskHandler.class);

    @Autowired
    private CCDClient ccdClient;

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        try {
            Map<String, Object> taskVariables = externalTask.getAllVariables();
            Long caseId = (Long) taskVariables.get("caseId");
            String judgmentProcessId = externalTask.getProcessInstanceId();
            caseId = extractClaimId(externalTask.getBusinessKey());

            logger.debug("******************...................*****************");
            logger.debug("****     CaseId from External Task    ******" + caseId);
            logger.debug("****     Judgment Process Id from External Task    ******" + judgmentProcessId);
            logger.debug("******************...................*****************");

            ccdClient.updateJudgment(caseId, judgmentProcessId);

            Map<String, Object> variablesToBeSupplied = new HashMap<>();
            variablesToBeSupplied.put("paperResponsePresent", true);
            externalTaskService.complete(externalTask, variablesToBeSupplied);

        } catch (Exception gene) {
            System.out.println("EXCEPTION>>>>>>" + gene.getMessage());
            gene.printStackTrace();
        }
    }

    private Long extractClaimId(String businessKey){
        return Long.valueOf(businessKey.substring(businessKey.indexOf("S-")+2));
    }
}

