package com.apler.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static String timestamp2time(String timestamp){
        Long ts = Long.parseLong(timestamp)*1000;
        Date date = new Date();
        date.setTime(ts);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
    }

    public static String timestamp2time(int timestamp){
        Long ts = 1000*(long)(timestamp);
        Date date = new Date();
        date.setTime(ts);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
    }
}
