package com.apler.entity.favorite.article;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FavoriteMultiArticle {
    @JsonProperty("rows")
    private List<ArticleWithType> articleWithTypeList;
    @JsonProperty("last_id")
    private int lastId;

    @JsonProperty("is_over")
    private int isOver;
}
