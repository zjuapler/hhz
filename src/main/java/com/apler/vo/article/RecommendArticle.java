package com.apler.vo.article;

import com.apler.vo.Counter;
import com.apler.vo.user.info.UserInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Apler
 */
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
