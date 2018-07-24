package com.apler.vo.activity;

import com.apler.util.PicUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoverPic {
    @JsonProperty("o_nphone")
    private String coverPicUrl;

    public String getCoverPicUrl(){
        return PicUtil.vivid(this.coverPicUrl);
    }
}
