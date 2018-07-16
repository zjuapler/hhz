package com.apler.templateUtil;

import com.sun.jndi.toolkit.url.Uri;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TemplateUtil {
//    public static Map<String, String> getQueryStringMap(String url){
//        String qs = url.split("\\?")[1];
//        String[] splited = qs.split("&");
//        Map<String, String> qsMap = new HashMap<>();
//        for (String s : splited){
//            String key = s.split("=")[0];
//            String value = s.split("=")[1];
//            qsMap.put(key, value);
//        }
//        return qsMap;
//    }
//
//    public static float getLeftPaddingOfImageLink(String url){
//        Map<String, String> map = getQueryStringMap(url);
//        float width = Float.parseFloat(map.get("w"));
//        float height = Float.parseFloat(map.get("h"));
//        float newWidth;
//        if (width > height){
//            newWidth = 720;
//        } else {
//            newWidth = width*720/height;
//        }
//        return (720-newWidth)/2 + 15;
//    }
}
