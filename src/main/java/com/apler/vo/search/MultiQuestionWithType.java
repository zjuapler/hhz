package com.apler.vo.search;

import com.apler.vo.question.Question;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiQuestionWithType {
    @JsonProperty("is_over")
    private int isOver;

    @JsonProperty("rows")
    private List<Question> questionList;
}
