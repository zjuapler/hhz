package com.apler.util;

import javax.servlet.http.Cookie;

/**
 * @author Apler
 */
public class CookieUtil {
    public static String getHhzToken(Cookie[] cookies){
        String hhzToken = null;
        String hhzTokenKey = "hhz_token";
        for (Cookie cookie : cookies){
            if (hhzTokenKey.equals(cookie.getName())){
                hhzToken = cookie.getValue();
            }
        }
        return hhzToken;
    }

    public static String getUid(Cookie[] cookies){
        String uid=null;
        String uidKey = "uid";
        for (Cookie cookie : cookies){
            if (uidKey.equals(cookie.getName())){
                uid = cookie.getValue();
            }
        }
        return uid;
    }
}
