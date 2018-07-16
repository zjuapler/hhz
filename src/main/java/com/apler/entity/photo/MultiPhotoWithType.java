package com.apler.entity.photo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiPhotoWithType {
    @JsonProperty("is_over")
    private int isOver;

    @JsonProperty("search_type")
    private int searchType;

    @JsonProperty("rows")
    private List<PhotoWithType> photoWithTypeList;
}
