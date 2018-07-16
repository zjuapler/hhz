package com.apler.entity.house;

import com.apler.entity.Counter;
import com.apler.entity.userInfo.UserInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecommendHouseInfo {
    @JsonProperty("article_id")
    private String id;

    @JsonProperty("article_info")
    private BriefHouseInfo briefHouseInfo;

    private Counter counter;

    @JsonProperty("user_info")
    private UserInfo userInfo;
}
