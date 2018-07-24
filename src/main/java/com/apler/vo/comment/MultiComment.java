package com.apler.vo.comment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiComment {
    @JsonProperty("rows")
    private List<Comment> commentList;

    @JsonProperty("is_over")
    private int isOver;
}
