package com.apler.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Apler
 */
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
