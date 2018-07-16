package com.apler.entity.following;

import com.apler.entity.answer.Answer;
import com.apler.entity.article.RecommendArticle;
import com.apler.entity.house.RecommendHouseInfo;
import com.apler.entity.photo.Photo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FollowingObject {
    private int type;

    @JsonProperty("action_info")
    private ActionInfo actionInfo;

    @JsonProperty("photo")
    private Photo photo;

    @JsonProperty("answer")
    private Answer answer;

    @JsonProperty("blank")
    private RecommendArticle article;

    @JsonProperty("article")
    private RecommendHouseInfo house;
}
