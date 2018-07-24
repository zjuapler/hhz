package com.apler.vo.comment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HotCommentResponse {
    private int code;

    @JsonProperty("data")
    private HotComment hotComment;

    private String msg;
}
