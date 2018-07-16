package com.apler.entity.following;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Following {
    @JsonProperty("dynamic_list")
    private List<FollowingObject> followingObjectList;

    @JsonProperty("start_id")
    private int startId;

    @JsonProperty("is_over")
    private int isOver;

    @JsonProperty("have_new_dynamic")
    private int haveNewDynamic;

    @JsonProperty("have_dynamic_feeds")
    private int haveDynamicFeeds;
}
