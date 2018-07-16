package com.apler.entity.comment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiCommentResponse {
    private int code;

    @JsonProperty("data")
    private MultiComment multiComment;

    private String msg;
}
