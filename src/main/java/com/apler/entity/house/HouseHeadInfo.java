package com.apler.entity.house;

import com.apler.util.PicUtil;
import com.apler.util.TimeUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HouseHeadInfo {
    private String title;

    @JsonProperty("cover_pic_url")
    private String coverPicUrl;

    public String getCoverPicUrl(){
        return PicUtil.vivid(this.coverPicUrl);
    }

    @JsonProperty("ori_cover_pic_url")
    private String oriCoverPicUrl;

    public String getOriCoverPicUrl(){
        return PicUtil.vivid(this.oriCoverPicUrl);
    }

    @JsonProperty("space_sort_test")
    private String spaceSortTest;

    private String description;

    private String status;

    @JsonProperty("addtime")
    private String addTime;

    public String getAddTime(){
        TimeUtil util = new TimeUtil();
        return util.timestamp2time(this.addTime);
    }

    @JsonProperty("operation_title")
    private String operationTitle;
}
