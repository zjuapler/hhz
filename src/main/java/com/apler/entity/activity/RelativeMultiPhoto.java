package com.apler.entity.activity;

import com.apler.entity.photo.Photo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RelativeMultiPhoto {
    @JsonProperty("last_id")
    private int lastId;

    @JsonProperty("is_over")
    private int isOver;

    @JsonProperty("rows")
    private List<Photo> photoList;
}
