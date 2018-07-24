package com.apler.vo.article;

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
public class BriefArticleInfo {
    private String id;
    private String title;

    @JsonProperty("fulltext")
    private String fullText;
    private int type;
    private String uid;

    @JsonProperty("cover_pic_id")
    private String coverPicId;

    @JsonProperty("pic_url")
    private String coverPicUrl;

    public String getCoverPicUrl(){
        return PicUtil.vivid(this.coverPicUrl);
    }

    @JsonProperty("user_info")
    private UserInfo userInfo;

}
