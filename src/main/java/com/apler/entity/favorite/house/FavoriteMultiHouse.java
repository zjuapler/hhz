package com.apler.entity.favorite.house;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FavoriteMultiHouse {
    @JsonProperty("rows")
    private List<HouseWithType> houseWithTypeList;
    @JsonProperty("last_id")
    private int lastId;

    @JsonProperty("is_over")
    private int isOver;
}
