package com.apler.vo.house;

import com.apler.vo.Counter;
import com.apler.vo.user.info.UserInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class House {
    @JsonProperty("article_id")
    private String id;

    @JsonProperty("article_info")
    private HouseInfo houseInfo;

    @JsonProperty("user_info")
    private UserInfo userInfo;

    private Counter counter;

    @JsonProperty("user_article_list")
    private List<RecommendHouseInfo> userHouseInfoList;

    @JsonProperty("rd_harea_list")
    private List<RecommendHouseInfo> recommendAreaHouseInfoList;

    @JsonProperty("rd_htype_list")
    private List<RecommendHouseInfo> recommendTypeHouseInfoList;
}
