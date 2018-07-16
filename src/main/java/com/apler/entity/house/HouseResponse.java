package com.apler.entity.house;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HouseResponse {
    private int code;

    @JsonProperty("data")
    private House house;

    private String msg;
}
