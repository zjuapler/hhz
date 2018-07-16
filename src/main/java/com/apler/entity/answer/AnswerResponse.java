package com.apler.entity.answer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnswerResponse {
    private int code;

    @JsonProperty("data")
    private Answer answer;

    private String msg;
}
