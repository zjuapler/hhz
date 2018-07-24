package com.apler.vo.house;

import com.apler.vo.Counter;
import com.apler.util.PicUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Apler
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HousePic {
    @JsonProperty("photo_id")
    private String id;

    @JsonProperty("ori_pic_url")
    private String oriPicUrl;

    public String getOriPicUrl(){
        return PicUtil.vivid(this.oriPicUrl);
    }

    private int favLabelMarginLeft;

    public int getFavLabelMarginLeft(){
        return PicUtil.getLabelMarginLeft(this.oriPicUrl);
    }

    @JsonProperty("pic_id")
    private String picId;

    private String remark;

    @JsonProperty("img_tags")
    private String imgTags;

    private Counter counter;

}
