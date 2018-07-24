package com.apler.vo.favorite.article;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FavoriteMultiArticleResponse {
    private int code;

    @JsonProperty("data")
    private FavoriteMultiArticle favoriteMultiArticle;

    private String msg;
}
