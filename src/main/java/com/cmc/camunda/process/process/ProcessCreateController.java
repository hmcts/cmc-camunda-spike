package com.cmc.camunda.process.process;

import com.cmc.camunda.model.StartRequest;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ProcessCreateController {

    @Autowired
    private ProcessCreateTask processCreateTask;

    @RequestMapping(value = "/process/judgment", method = POST)
    @ResponseBody
    public String startJudgmentProcess(@RequestBody StartRequest request) {
        return processCreateTask.createProcess(request.getCaseId());
    }
}
