package com.apler.vo.house;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class HouseBriefInfo {
    @JsonProperty("aid")
    private String id;

    private String area;

    @JsonProperty("house_stuff")
    private String houseStuff;

    @JsonProperty("house_size")
    private String houseSize;


}
