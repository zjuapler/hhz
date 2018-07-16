package com.apler.entity.article;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecommendBlock {
    private String title;

    @JsonProperty("list")
    private List<RecommendArticle> recommendArticleInfoList;
}
