package com.apler.vo.question;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiQuestion {
    @JsonProperty("is_over")
    private int isOver;

    @JsonProperty("rows")
    private List<Question> questionList;
}
