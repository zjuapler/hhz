package com.apler.entity.house;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class HouseArea {
    private String name;
    @JsonProperty("show_pics")
    private List<HousePic> showPics;
}
