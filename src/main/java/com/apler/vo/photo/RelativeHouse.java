package com.apler.vo.photo;

import com.apler.vo.house.House;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RelativeHouse {
    @JsonProperty("article")
    private House house;
}
