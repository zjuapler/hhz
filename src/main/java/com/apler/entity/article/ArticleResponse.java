package com.apler.entity.article;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleResponse {
    private int code;

    @JsonProperty("data")
    private Article article;
    private String msg;
}
