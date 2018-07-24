package com.apler.vo.following;

import com.apler.vo.user.info.UserInfo;
import com.apler.util.TimeUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Apler
 */
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
