package com.apler.vo.recommend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Recommend {
    @JsonProperty("is_over")
    private int isOver;

    @JsonProperty("list")
    private List<RecommendObject> recommendObjectList;
}
