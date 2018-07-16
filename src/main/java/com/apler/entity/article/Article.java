package com.apler.entity.article;

import com.apler.entity.Counter;
import com.apler.entity.userInfo.UserInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Article {
    @JsonProperty("user_info")
    private UserInfo userInfo;

    @JsonProperty("blank_info")
    private ArticleInfo articleInfo;

    private Counter counter;

    @JsonProperty("admin_tags")
    private Map<String, String> adminTagMap;

    @JsonProperty("relative_article")
    private List<BriefArticleInfo> relativeArticleInfoList;

    @JsonProperty("recommend_block_list")
    private List<RecommendBlock> recommendBlockList;
}
