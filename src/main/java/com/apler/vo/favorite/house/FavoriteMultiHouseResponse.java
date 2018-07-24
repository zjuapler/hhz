package com.apler.vo.favorite.house;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FavoriteMultiHouseResponse {
    private int code;

    @JsonProperty("data")
    private FavoriteMultiHouse favoriteMultiHouse;

    private String msg;
}
