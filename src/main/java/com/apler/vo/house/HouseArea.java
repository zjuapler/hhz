package com.apler.vo.house;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class HouseArea {
    private String name;
    @JsonProperty("show_pics")
    private List<HousePic> showPics;
}
