package com.apler.vo.user.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Emblem {
    @JsonProperty("emblem_type")
    private int emblemType;
    private String name;
    private String describe;
    private String logo;

    @JsonProperty("round_logo")
    private String roundLogo;

    @JsonProperty("logo_prefix")
    private String logoPrefix;

    private String status;
    private String id;
    private String uid;

    @JsonProperty("get_time")
    private String getTime;
}
