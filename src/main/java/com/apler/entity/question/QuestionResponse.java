package com.apler.entity.question;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionResponse {
    private int code;

    @JsonProperty("data")
    private Question question;

    private String msg;
}
