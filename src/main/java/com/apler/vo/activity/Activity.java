package com.apler.vo.activity;

import com.apler.vo.Counter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Activity {
    @JsonProperty("activity_info")
    private ActivityInfo activityInfo;

    private Counter counter;

    @JsonProperty("cover_pic_list")
    private List<CoverPic> coverPicList;

    private String coverPicUrl;

    public String getCoverPicUrl(){
        CoverPic coverPic = this.coverPicList.get(0);
        return coverPic.getCoverPicUrl();
    }
}
