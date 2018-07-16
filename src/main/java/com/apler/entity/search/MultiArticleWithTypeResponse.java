package com.apler.entity.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiArticleWithTypeResponse {
    private int code;

    private String msg;

    @JsonProperty("data")
    private MultiArticleWithType multiArticleWithType;
}
