package com.apler.vo.guide;

import com.apler.util.PicUtil;
import com.apler.util.TimeUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GuideInfo {
    @JsonProperty("guide_id")
    private String id;

    @JsonProperty("guide_type")
    private int guideType;

    private String title;

    @JsonProperty("cover_pic_url")
    private String coverPicUrl;

    public String getCoverPicUrl(){
        return PicUtil.vivid(this.coverPicUrl);
    }

    @JsonProperty("addtime")
    private String addTime;

    public String getAddTime(){
        TimeUtil util = new TimeUtil();
        return util.timestamp2time(this.addTime);
    }
}
