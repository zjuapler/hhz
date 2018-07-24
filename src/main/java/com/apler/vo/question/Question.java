package com.apler.vo.question;

import com.apler.vo.Counter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {
    @JsonProperty("question_info")
    private QuestionInfo questionInfo;

    private Counter counter;

    private BestAnswer bestAnswer;
}
