package com.cmc.camunda.process.process;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.StandardToStringStyle;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CreateMessage {
    public final String messageName;
    public final String businessKey;
    public final Map<String, ProcessVariable> variables;

    public CreateMessage(String messageName, String businessKey, Map<String, ProcessVariable> processVariables) {
        this.messageName = messageName;
        this.businessKey = businessKey;
        this.variables = Collections.unmodifiableMap(new HashMap<>(processVariables));
    }

   /* @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ourStyle());
    }

    public static StandardToStringStyle ourStyle() {
        StandardToStringStyle standardToStringStyle = new StandardToStringStyle();
        standardToStringStyle.setUseClassName(false);
        standardToStringStyle.setUseIdentityHashCode(false);
        standardToStringStyle.setContentStart("[");
        standardToStringStyle.setFieldSeparator(System.lineSeparator() + "  ");
        standardToStringStyle.setFieldSeparatorAtStart(true);
        standardToStringStyle.setContentEnd(System.lineSeparator() + "]");
        return standardToStringStyle;
    }*/
}
