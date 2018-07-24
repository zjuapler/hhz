package com.apler.vo.comment;

import com.apler.vo.user.info.UserInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {
    @JsonProperty("user_info")
    private UserInfo userInfo;

    @JsonProperty("comment")
    private CommentInfo commentInfo;

    @JsonProperty("replay_info")
    private ReplayInfo replayInfo;
}
