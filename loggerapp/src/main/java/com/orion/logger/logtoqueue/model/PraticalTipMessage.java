package com.orion.logger.logtoqueue.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class PraticalTipMessage  {

    private final String text;
    private final int priority;
    private final boolean secret;

    public PraticalTipMessage(@JsonProperty("texto") final String text,
                            @JsonProperty("priridade") final int priority,
                            @JsonProperty("secreto") final boolean secret) {
        this.text = text;
        this.priority = priority;
        this.secret = secret;
        
    }

    @Override
    public String toString() {
        return "PraticalTipMessage {priority=" 
                + priority + ", secret=" 
                + secret 
                + ", text=" 
        + text + "}";
    }

    
}
