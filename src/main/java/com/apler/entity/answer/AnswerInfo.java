package com.apler.entity.answer;

import com.apler.util.TimeUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnswerInfo {
    @JsonProperty("answer_id")
    private String id;

    @JsonProperty("id")
    private String answerId;

    public String getId(){
        if (this.id != null){
            return this.id;
        } else {
            return this.answerId;
        }
    }

    @JsonProperty("q_id")
    private String questionId;

    private String content;

    @JsonProperty("addtime")
    private String addTime;

    public String getAddTime(){
        TimeUtil util = new TimeUtil();
        return util.timestamp2time(this.addTime);
    }

    @JsonProperty("imgs")
    private List<Img> imgList;

    @JsonProperty("is_favorited")
    private int isFavorited;

    @JsonProperty("is_liked")
    private int isLiked;
}
