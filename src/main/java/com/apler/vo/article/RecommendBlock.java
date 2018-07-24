package com.apler.vo.article;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class RecommendBlock {
    private String title;

    @JsonProperty("list")
    private List<RecommendArticle> recommendArticleInfoList;
}
