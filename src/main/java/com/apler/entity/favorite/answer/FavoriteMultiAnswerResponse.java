package com.apler.entity.favorite.answer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FavoriteMultiAnswerResponse {
    private int code;

    @JsonProperty("data")
    private FavoriteMultiAnswer favoriteMultiAnswer;
    private String msg;
}
