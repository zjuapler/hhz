package com.apler.entity.favorite.article;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FavoriteMultiArticleResponse {
    private int code;

    @JsonProperty("data")
    private FavoriteMultiArticle favoriteMultiArticle;

    private String msg;
}
