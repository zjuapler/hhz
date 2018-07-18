package com.apler.entity.photo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RelativeHouseResponse {
    private int code;

    @JsonProperty("data")
    private RelativeHouse relativeHouse;

    private String msg;
}