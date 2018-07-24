package com.apler.vo.house;

import com.apler.util.PicUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HouseInfo {
    @JsonProperty("head_info")
    private HouseHeadInfo houseHeadInfo;

    @JsonProperty("house_info")
    private HouseBriefInfo houseBriefInfo;

    @JsonProperty("show_photo_info")
    private List<HouseArea> showPhotoInfo;

    @JsonProperty("article_id")
    private String id;

    @JsonProperty("cover_pic_url")
    private String coverPicUrl;

    public String getCoverPicUrl(){
        return PicUtil.vivid(this.coverPicUrl);
    }

    private String title;

    @JsonProperty("is_favorited")
    private int isFavorited;

    @JsonProperty("is_liked")
    private int isLiked;
}
