package com.apler.vo.answer;

import com.apler.util.PicUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Img {
    @JsonProperty("new_pic_url")
    private String picUrl;

    public String getPicUrl(){
        return PicUtil.vivid(this.picUrl);
    }
}
