package com.apler.vo.question;

import com.apler.vo.answer.Answer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RelativeMultiAnswer {
    @JsonProperty("rows")
    private List<Answer> answerList;

    @JsonProperty("is_over")
    private int isOver;
}
