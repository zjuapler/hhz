package com.apler.vo.activity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiActivityResponse {
    private int code;
    private String msg;

    @JsonProperty("data")
    private MultiActivity multiActivity;
}
