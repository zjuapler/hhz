package com.apler.entity.activity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiActivityResponse {
    private int code;
    private String msg;

    @JsonProperty("data")
    private MultiActivity multiActivity;
}
