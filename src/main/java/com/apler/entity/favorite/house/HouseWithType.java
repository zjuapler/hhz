package com.apler.entity.favorite.house;

import com.apler.entity.house.House;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HouseWithType {
    private String type;
    @JsonProperty("article")
    private House house;
}
