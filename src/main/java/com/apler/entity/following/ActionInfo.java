package com.apler.entity.following;

import com.apler.entity.userInfo.UserInfo;
import com.apler.util.TimeUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActionInfo {
    private int type;

    @JsonProperty("addtime")
    private String addTime;

    public String getAddTime(){
        return TimeUtil.timestamp2time(this.addTime);
    }

    @JsonProperty("user_info")
    private UserInfo userInfo;
}
