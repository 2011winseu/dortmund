package com.dortmund.westfalen.assets;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sunmingwei on 16/6/4.
 */
public class TimeBoard {

    private static DateFormat dateFormatYMD = new SimpleDateFormat("yyyy-MM-dd");

    private static DateFormat dateFormatYMDHMS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date createYMD(String time) {
        Date date = new Date();
        try {
            date = dateFormatYMD.parse(time);
        } catch (Exception e) {

        }
        return date;
    }

    public static Date createYMDHMS(String time) {
        Date date = new Date();
        try {
            date = dateFormatYMDHMS.parse(time);
        } catch (Exception e) {

        }
        return date;
    }
}
