package com.apler.vo.favorite.photo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FavoriteMultiPhotoResponse {
    private int code;
    @JsonProperty("data")
    private FavoriteMultiPhoto favoriteMultiPhoto;
    private String msg;
}
