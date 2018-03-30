package com.rewardshoop.utils;

import com.rewardshoop.constants.CommonConst;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    /**
     * 生成时间戳(10位int)
     */
    public static int currentTime() {
        long currentTime = System.currentTimeMillis();
        return (int) (currentTime / 1000);
    }

    /**
     * 把时间戳转换成时间
     *
     * @param currentTime
     * @param dateFormat
     * @return
     */
    public static String currentTimeToDate(long currentTime, String dateFormat) {
        if ((currentTime + "").length() == 10) {
            currentTime = currentTime * 1000;
        }
        Date d = new Date(currentTime);
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(d);

    }

    /**
     * 默认时间格式
     *
     * @param currentTime
     * @return
     */
    public static String currentTimeToDate(long currentTime) {
        String dateFormat = CommonConst.Date_Time_Format;
        return currentTimeToDate(currentTime, dateFormat);
    }

    /**
     * 默认时间格式
     *
     * @param date
     * @return
     */
    public static Integer dateToCurrent(String date) {
        String dateFormat = CommonConst.Date_Time_Format;
        return dateToCurrent(date, dateFormat);
    }

    /**
     * 时间转时间戳
     *
     * @param date
     * @param dateFormat
     * @return
     */
    public static Integer dateToCurrent(String date, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        long currentTime = 0;
        try {
            currentTime = simpleDateFormat.parse(date).getTime();
            return (int) (currentTime / 1000);
        } catch (ParseException e) {
            return null;
        }
    }
}
