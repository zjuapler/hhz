package com.apler.entity.guide;

import com.apler.entity.Counter;
import com.apler.entity.userInfo.UserInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Guide {
    @JsonProperty("guide_info")
    private GuideInfo guideInfo;

    @JsonProperty("user_info")
    private UserInfo userInfo;

    private Counter counter;
}
