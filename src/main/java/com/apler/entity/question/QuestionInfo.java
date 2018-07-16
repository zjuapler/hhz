package com.apler.entity.question;

import com.apler.util.TimeUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionInfo {
    private String id;
    private String title;

    private String content;
    @JsonProperty("html_content")
    private String htmlContent;

    @JsonProperty("is_followed")
    private int isFollowed;

    @JsonProperty("addtime")
    private String addTime;

    public String getAddTime(){
        if(this.addTime == null){
            return null;
        } else{
            return TimeUtil.timestamp2time(this.addTime);
        }
    }

    private String color;

    public String getColor(){
        if(this.color == null || this.color.equals("Array")){
            int r = (int) (Math.random() * 168);
            int g = (int) (Math.random() * 168);
            int b = (int) (Math.random() * 168);
            String r1 = Integer.toHexString(r);
            String g1 = Integer.toHexString(g);
            String b1 = Integer.toHexString(b);
            if (r1.length() == 1){
                r1 = "0"+r1;
            }
            if (g1.length() == 1){
                g1 = "0"+g1;
            }
            if (b1.length() == 1){
                b1 = "0"+b1;
            }
//            log.info("r1,g1,b1",r1,g1,b1);
            return r1+g1+b1;
        } else {
            return this.color;
        }
    }
}
