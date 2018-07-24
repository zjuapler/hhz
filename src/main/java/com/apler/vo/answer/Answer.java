package com.apler.vo.answer;

import com.apler.vo.Counter;
import com.apler.vo.question.QuestionInfo;
import com.apler.vo.user.info.UserInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Apler
 */
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
