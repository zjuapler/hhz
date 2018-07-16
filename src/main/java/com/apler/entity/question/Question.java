package com.apler.entity.question;

import com.apler.entity.Counter;
import com.apler.entity.userInfo.UserInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {
    @JsonProperty("question_info")
    private QuestionInfo questionInfo;

    private Counter counter;

    private BestAnswer bestAnswer;
}
