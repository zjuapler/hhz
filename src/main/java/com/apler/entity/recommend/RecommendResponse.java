package com.apler.entity.recommend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecommendResponse {
    private int code;

    @JsonProperty("data")
    private Recommend recommend;
}
