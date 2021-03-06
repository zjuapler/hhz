package com.apler.vo.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiHouseWithTypeResponse {
    private int code;

    private String msg;

    @JsonProperty("data")
    private MultiHouseWithType multiHouseWithType;
}
