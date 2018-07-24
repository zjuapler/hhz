package com.apler.vo.following;

import com.apler.vo.answer.Answer;
import com.apler.vo.article.RecommendArticle;
import com.apler.vo.house.RecommendHouseInfo;
import com.apler.vo.photo.Photo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class FollowingObject {
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
