package com.apler.util;

import javax.servlet.http.Cookie;

public class CookieUtil {
    public static String getHhzToken(Cookie[] cookies){
        String hhzToken=null;
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("hhz_token")){
                hhzToken = cookie.getValue();
            }
        }
        return hhzToken;
    }

    public static String getUid(Cookie[] cookies){
        String uid=null;
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("uid")){
                uid = cookie.getValue();
            }
        }
        return uid;
    }
}
