package com.apler.vo.activity;

import com.apler.vo.photo.Photo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Apler
 */
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
