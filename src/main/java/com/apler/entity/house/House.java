package com.apler.entity.house;

import com.apler.entity.Counter;
import com.apler.entity.userInfo.UserInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
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
