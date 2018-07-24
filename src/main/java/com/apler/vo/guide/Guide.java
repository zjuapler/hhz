package com.apler.vo.guide;

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
public class Guide {
    @JsonProperty("guide_info")
    private GuideInfo guideInfo;

    @JsonProperty("user_info")
    private UserInfo userInfo;

    private Counter counter;
}
