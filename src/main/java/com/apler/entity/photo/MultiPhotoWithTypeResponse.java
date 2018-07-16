package com.apler.entity.photo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiPhotoWithTypeResponse {
    private int code;

    @JsonProperty("data")
    private MultiPhotoWithType multiPhotoWithType;
}
