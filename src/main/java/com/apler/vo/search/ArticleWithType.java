package com.apler.vo.search;

import com.apler.vo.user.info.UserInfo;
import com.apler.util.PicUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleWithType {
    private int type;
    @JsonProperty("obj_id")
    private String id;

    private String title;

    @JsonProperty("pic_url")
    private String picUrl;

    public String getPicUrl(){
        return PicUtil.vivid(this.picUrl);
    }

    @JsonProperty("user_info")
    private UserInfo userInfo;
}
