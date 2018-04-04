package com.rewardshoop.constants;

public class EXDeliveryConst {
    /**
     * 调用快递鸟所需的用户识别ID
     */
    public static String EBusinessID = "1329601";

    /**
     * 加密key
     */
    public static String AppKey = "f2a979cb-271f-4936-a026-2c412ee97035";


    /**
     * 每条记录缓存时间
     */
    public static Integer DelayTime = 2 * 60 * 60 * 1000;

    /**
     * 快递鸟调用API
     */
    public static String Url = "http://api.kdniao.cc/Ebusiness/EbusinessOrderHandle.aspx";
    /**
     * 物流信息RequestType
     */
    public static String InstantQueryRequestType = "1002";

    /**
     * 单号识别RequestType
     */
    public static String LogisticCodeRecognitionRequestType = "2002";
}
