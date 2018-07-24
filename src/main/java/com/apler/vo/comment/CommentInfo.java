package com.apler.vo.comment;

import com.apler.util.TimeUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentInfo {
    private int id;
    private int uid;
    private int type;

    @JsonProperty("parentid")
    private int parentId;

    private String content;

    @JsonProperty("addtime")
    private int addTime;

    public String getAddTime(){
        return TimeUtil.timestamp2time(this.addTime);
    }

    private List<Mention> mentionList;

    @JsonProperty("like_num")
    private int likeNum;

    @JsonProperty("is_owner")
    private int isOwner;

    @JsonProperty("is_like")
    private int isLiked;
}
