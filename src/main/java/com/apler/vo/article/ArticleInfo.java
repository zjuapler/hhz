package com.apler.vo.article;

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
public class ArticleInfo {
    @JsonProperty("bid")
    private String id;

    private String title;
    private String remark;
    private String content;

    @JsonProperty("cover_pic_id")
    private String coverPicId;

    @JsonProperty("cover_pic_url")
    private String coverPicUrl;

    public String getCoverPicUrl(){
        return PicUtil.vivid(this.coverPicUrl);
    }

    @JsonProperty("addtime")
    private String addTime;

    public String getAddTime(){
        return TimeUtil.timestamp2time(this.addTime);
    }

    @JsonProperty("edittime")
    private String editTime;

    @JsonProperty("admin_tag")
    private String adminTag;

    @JsonProperty("admin_recommend_tag")
    private String adminRecommendTag;

    @JsonProperty("user_tag")
    private String userTag;

    @JsonProperty("channel_tag")
    private String channelTag;

    @JsonProperty("publish_time")
    private String publishTime;

    @JsonProperty("main_tag")
    private String mainTag;

    @JsonProperty("is_favorited")
    private int isFavorited;

    @JsonProperty("is_liked")
    private int isLiked;
}
