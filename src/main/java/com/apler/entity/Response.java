package com.apler.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    public Response(boolean isSuccess){
        if (isSuccess){
            code = 0;
        } else{
            code = 1;
        }
    }
    private int code;
}
