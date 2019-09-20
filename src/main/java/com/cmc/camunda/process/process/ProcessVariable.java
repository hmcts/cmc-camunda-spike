package com.cmc.camunda.process.process;

public class ProcessVariable {
    public final Object value;
    public final String type;

    public ProcessVariable(Object value, String type)
    {
        this.value = value;
        this.type = type;
    }
}
