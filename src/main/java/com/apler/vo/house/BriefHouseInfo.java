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
public class BriefHouseInfo {
    @JsonProperty("aid")
    private String id;

    private String title;
    @JsonProperty("house_size")
    private String houseSize;

    @JsonProperty("house_type")
    private String houseType;

    @JsonProperty("cover_pic_url")
    private String coverPicUrl;

    public String getCoverPicUrl(){
        return PicUtil.vivid(this.coverPicUrl);
    }

    @JsonProperty("cover_pic_id")
    private String coverPicId;

    @JsonProperty("operation_title")
    private String operationTitle;

    @JsonProperty("addtime")
    private String addTime;

    public String getAddTime(){
        return TimeUtil.timestamp2time(this.addTime);
    }

    @JsonProperty("is_favorited")
    private int isFavorited;

    @JsonProperty("is_liked")
    private int isLiked;
}
