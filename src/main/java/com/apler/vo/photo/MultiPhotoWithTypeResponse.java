package com.apler.vo.photo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiPhotoWithTypeResponse {
    private int code;

    @JsonProperty("data")
    private MultiPhotoWithType multiPhotoWithType;
}
