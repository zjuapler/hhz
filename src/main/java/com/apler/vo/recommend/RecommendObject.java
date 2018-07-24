package com.apler.vo.recommend;

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
class RecommendObject {
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
