package com.apler.entity.article;

import com.apler.entity.Counter;
import com.apler.entity.userInfo.UserInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecommendArticle {
    @JsonProperty("bid")
    private String id;

    @JsonProperty("user_info")
    private UserInfo userInfo;

    @JsonProperty("blank_info")
    private ArticleInfo articleInfo;

    private Counter counter;
}
