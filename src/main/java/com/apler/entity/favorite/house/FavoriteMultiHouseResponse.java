package com.apler.entity.favorite.house;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FavoriteMultiHouseResponse {
    private int code;

    @JsonProperty("data")
    private FavoriteMultiHouse favoriteMultiHouse;

    private String msg;
}
