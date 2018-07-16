package com.apler.entity.photo;

import com.apler.entity.house.House;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RelativeHouse {
    @JsonProperty("article")
    private House house;
}
