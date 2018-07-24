package com.apler.vo.favorite.article;

import com.apler.vo.article.Article;
import com.apler.vo.guide.Guide;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class ArticleWithType {
    private String type;

    @JsonProperty("blank")
    private Article article;

    @JsonProperty("guide")
    private Guide guide;
}
