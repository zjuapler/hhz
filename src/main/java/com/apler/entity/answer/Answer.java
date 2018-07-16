package com.apler.entity.answer;

import com.apler.entity.Counter;
import com.apler.entity.question.QuestionInfo;
import com.apler.entity.userInfo.UserInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Answer {
    @JsonProperty("answer_info")
    private AnswerInfo answerInfo;

    @JsonProperty("question_info")
    private QuestionInfo questionInfo;

    @JsonProperty("user_info")
    private UserInfo userInfo;

    private Counter counter;
}
