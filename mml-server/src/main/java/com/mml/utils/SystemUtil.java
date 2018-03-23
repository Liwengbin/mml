package com.mml.utils;

import java.util.Date;

public class SystemUtil {
    public static Date getNowTime(){
        Date now = new Date(System.currentTimeMillis());
        return now;
    }
}
