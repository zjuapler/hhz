package com.apler.vo.house;

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
public class HouseHeadInfo {
    private String title;

    @JsonProperty("cover_pic_url")
    private String coverPicUrl;

    public String getCoverPicUrl(){
        return PicUtil.vivid(this.coverPicUrl);
    }

    @JsonProperty("space_sort_test")
    private String spaceSortTest;

    private String description;

    private String status;

    @JsonProperty("addtime")
    private String addTime;

    public String getAddTime(){
        return TimeUtil.timestamp2time(this.addTime);
    }

    @JsonProperty("operation_title")
    private String operationTitle;
}
