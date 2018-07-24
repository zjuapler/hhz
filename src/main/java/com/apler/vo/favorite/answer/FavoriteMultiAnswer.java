package com.apler.vo.favorite.answer;

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
public class FavoriteMultiAnswer {
    @JsonProperty("last_id")
    private String lastId;

    @JsonProperty("rows")
    private List<Answer> answerList;

    @JsonProperty("is_over")
    private int isOver;
}
