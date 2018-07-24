package com.apler.vo.house;

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
public class RecommendHouseInfo {
    @JsonProperty("article_id")
    private String id;

    @JsonProperty("article_info")
    private BriefHouseInfo briefHouseInfo;

    private Counter counter;

    @JsonProperty("user_info")
    private UserInfo userInfo;
}
