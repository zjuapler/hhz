package com.apler.vo.photo;

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
public class Photo {
    @JsonProperty("user_info")
    private UserInfo userInfo;

    @JsonProperty("photo_info")
    private PhotoInfo photoInfo;

    @JsonProperty("counter")
    private Counter counter;

    @JsonProperty("activity")
    private Activity activity;

    private String relativeHouseId;
}
