package com.apler.entity.photo;

import com.apler.util.PicUtil;
import com.apler.util.TimeUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PhotoInfo {
    private String id;

    @JsonProperty("pic_url")
    private String picUrl;

    public String getPicUrl(){
        return PicUtil.vivid(this.picUrl);
    }

    @JsonProperty("ori_pic_url")
    private String oriPicUrl;

    public String getOriPicUrl(){
        return PicUtil.vivid(this.oriPicUrl);
    }

    private int houseLabelMarginLeft;

    public int getHouseLabelMarginLeft(){
        return PicUtil.getLabelMarginLeft(this.oriPicUrl);
    }

    private String remark;
    private String houseType;

    @JsonProperty("is_favorited")
    private int isFavorited;

    @JsonProperty("is_liked")
    private int isLiked;

    @JsonProperty("is_join_article")
    private int isJoinArticle;

    @JsonProperty("addtime")
    private String addTime;

    public String getAddTime(){
        TimeUtil util = new TimeUtil();
        return util.timestamp2time(this.addTime);
    }

    @JsonProperty("tags")
    private List<Tag> tagList;

    @JsonProperty("remark_tags")
    private List<RemarkTag> remarkTagList;
}
