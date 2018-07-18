package com.apler.entity.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiHouseWithType {
    @JsonProperty("is_over")
    private int isOver;

    @JsonProperty("rows")
    private List<HouseWithType> houseWithTypeList;
}