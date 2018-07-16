package com.apler.entity.question;

import com.apler.entity.answer.Answer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RelativeMultiAnswer {
    @JsonProperty("rows")
    private List<Answer> answerList;

    @JsonProperty("is_over")
    private int isOver;
}
