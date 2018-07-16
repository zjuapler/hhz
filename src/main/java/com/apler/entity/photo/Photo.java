package com.apler.entity.photo;

import com.apler.entity.Counter;
import com.apler.entity.userInfo.UserInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

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
