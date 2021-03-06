package com.apler.vo.question;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionResponse {
    private int code;

    @JsonProperty("data")
    private Question question;

    private String msg;
}
