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
public class ActivityInfo {
    @JsonProperty("activity_id")
    private String id;

    private String title;
    private String content;

    @JsonProperty("html_content")
    private String htmlContent;

    @JsonProperty("cover_pic_url")
    private String coverPicUrl;

    public String getCoverPicUrl(){
        return PicUtil.vivid(this.coverPicUrl);
    }

    @JsonProperty("cover_info")
    private String photoList;
}
