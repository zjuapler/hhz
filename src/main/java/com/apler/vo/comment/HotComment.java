package com.apler.vo.comment;

import com.apler.vo.Counter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HotComment {
    private Counter counter;

    @JsonProperty("comments")
    private List<Comment> commentList;

    @JsonProperty("host_user_info")
    private HostUserInfo hostUserInfo;

    @JsonProperty("is_over")
    private int isOver;

    @JsonProperty("top_comment")
    private Comment topComment;
}
