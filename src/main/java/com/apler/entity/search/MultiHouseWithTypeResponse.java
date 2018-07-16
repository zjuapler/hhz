package com.apler.entity.search;

import com.apler.entity.photo.MultiPhotoWithType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiHouseWithTypeResponse {
    private int code;

    private String msg;

    @JsonProperty("data")
    private MultiHouseWithType multiHouseWithType;
}
