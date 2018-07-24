package com.apler.vo.favorite.house;

import com.apler.vo.house.House;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class HouseWithType {
    private String type;
    @JsonProperty("article")
    private House house;
}
