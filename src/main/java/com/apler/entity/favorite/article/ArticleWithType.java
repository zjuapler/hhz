package com.apler.entity.favorite.article;

import com.apler.entity.article.Article;
import com.apler.entity.guide.Guide;
import com.apler.entity.house.House;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleWithType {
    private String type;

    @JsonProperty("blank")
    private Article article;

    @JsonProperty("guide")
    private Guide guide;
}
