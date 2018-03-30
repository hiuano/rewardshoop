package com.rewardshoop.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderNumberUtil {
    /**
     * 到9999就归0
     */
    private static int counter = 0;


    /**
     * 订单号长度22位
     *
     * @return
     */
    public synchronized static String getOrderNumber() {
        if (counter >= 9999) {
            counter = 0;
        }
        String date = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        String sequ = new DecimalFormat("0000").format(counter++);
        StringBuffer buffer = new StringBuffer(date).append(sequ);
        return buffer.toString();
    }


    /**
     * 订单号加前缀
     *
     * @param str
     * @return
     */
    public static String getOrderNumber(String str) {
        return CommonUtil.stitching(str, getOrderNumber());
    }

}