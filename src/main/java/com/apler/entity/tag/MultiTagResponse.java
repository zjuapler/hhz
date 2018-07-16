package com.apler.entity.tag;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiTagResponse {
    private int code;

    @JsonProperty("data")
    private MultiTag multiTag;
    private String msg;
}
