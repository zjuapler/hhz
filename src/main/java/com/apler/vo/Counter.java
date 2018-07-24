package com.apler.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Counter {
    private int comment;
    private int like;
    private int favorite;
    private int share;
    private int read;
    private int goods;
    private int answer;
    private int follow;
    private int joiner;

    @JsonProperty("photo_count")
    private int photoCount;
}
