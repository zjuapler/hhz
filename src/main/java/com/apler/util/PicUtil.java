package com.apler.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PicUtil {
    public static String vivid(String oriPicUrl){
        return oriPicUrl.replaceAll("o_nphone|sq_thumb|sq_phone", "o_phbig");
    }

    public static int getLabelMarginLeft(String url){
        log.info("oriPicUrl: " + url);
        String[] splitList = url.split("\\?");
        String queryString = splitList[splitList.length-1];
        splitList = queryString.split("&");
        String width = "";
        String height = "";
        for(String splited: splitList){
            String key = splited.split("=")[0];
            if (key.equals("w")) {
                width = splited.split("=")[1];
            } else if (key.equals("h")){
                height = splited.split("=")[1];
            }
        }
        float w = Float.parseFloat(width);
        float h = Float.parseFloat(height);
        if (w > h){
            w = 720;
        } else {
            w = w * 720 / h;
        }
        return (int) (720-w) / 2 + 15;
    }
}
