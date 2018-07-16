package com.apler.entity.recommend;

import com.apler.entity.answer.Answer;
import com.apler.entity.article.RecommendArticle;
import com.apler.entity.house.RecommendHouseInfo;
import com.apler.entity.photo.Photo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecommendObject {
    private int type;
    @JsonProperty("photo")
    private Photo recommendPhoto;

    @JsonProperty("blank")
    private RecommendArticle recommendArticle;

    @JsonProperty("article")
    private RecommendHouseInfo  recommendHouse;

    @JsonProperty("answer")
    private Answer recommendAnswer;

    @JsonProperty("recommend_info")
    private RecommendReason recommendReason;
}
