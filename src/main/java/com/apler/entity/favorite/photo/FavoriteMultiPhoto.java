package com.apler.entity.favorite.photo;

import com.apler.entity.photo.Photo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FavoriteMultiPhoto {
    @JsonProperty("rows")
    private List<Photo> photoList;
    private int count;
    @JsonProperty("is_over")
    private int isOver;
    @JsonProperty("last_id")
    private int lastId;
}
