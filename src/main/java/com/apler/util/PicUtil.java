package com.apler.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Apler
 */
@Slf4j
public class PicUtil {
    public static String vivid(String oriPicUrl){
        return oriPicUrl.replaceAll("o_nphone|sq_thumb|sq_phone", "o_phbig");
    }

    public static int getLabelMarginLeft(String url){
        String[] splitList = url.split("\\?");
        String queryString = splitList[splitList.length-1];
        String[] queryStringList = queryString.split("&");
        String width = "";
        String height = "";
        for(String qs: queryStringList){
            String key = qs.split("=")[0];
            if ("w".equals(key)) {
                width = qs.split("=")[1];
            } else if ("h".equals(key)){
                height = qs.split("=")[1];
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
