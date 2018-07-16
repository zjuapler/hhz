package com.apler.entity.following;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FollowingResponse {
    private int code;

    @JsonProperty("data")
    private Following following;
}
