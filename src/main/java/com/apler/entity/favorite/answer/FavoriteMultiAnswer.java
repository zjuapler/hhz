package com.apler.entity.favorite.answer;

import com.apler.entity.answer.Answer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

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
