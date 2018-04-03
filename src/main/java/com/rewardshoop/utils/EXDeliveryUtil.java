package com.rewardshoop.utils;

import com.rewardshoop.constants.EXDeliveryConst;
import com.rewardshoop.response.InstantQueryResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.NameValuePair;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 快递工具类,希望后者可以写个缓存缓存起来,毕竟每天只可调用30000次
 */
public class EXDeliveryUtil {

    private static String Url = EXDeliveryConst.Url;
    private static String EBusinessID = EXDeliveryConst.EBusinessID;
    private static String AppKey = EXDeliveryConst.AppKey;


    private static Map<String, String> getRequestData(Map<String, String> map, String RequestType) throws Exception {
        String requestData = JSONObject.fromObject(map).toString();
        map.clear();
        map.put("RequestData", URLEncoder.encode(requestData, "UTF-8"));
        map.put("EBusinessID", EBusinessID);
        map.put("DataSign", getDataSign(requestData));
        map.put("RequestType", RequestType);
        map.put("DataType", "2");
        return map;
    }

    /**
     * 电商Sign签名生成
     *
     * @param requestData 内容
     * @return DataSign签名
     */
    private static String getDataSign(String requestData) throws Exception {
        String result = EncryptionUtil.encryptMD5(requestData + AppKey).toLowerCase();
        result = EncryptionUtil.encryptBASE64(result.getBytes("UTF-8"));

        result = URLEncoder.encode(result, "UTF-8");
        return result;
    }

    /**
     * 快递信息查询
     *
     * @param logisticCode 订单号
     * @return
     * @throws Exception
     */
    public static InstantQueryResponse instantQuery(String logisticCode) throws Exception {

        JSONObject jsonObject = logisticCodeRecognition(logisticCode);
        if (!jsonObject.getBoolean("Success")) {
            return new InstantQueryResponse(false, jsonObject.getString("Code"));
        }
        JSONArray array = jsonObject.getJSONArray("Shippers");

        String shipperCode = array.getJSONObject(0).getString("ShipperCode");
        String shipperName = array.getJSONObject(0).getString("ShipperName");

        Map<String, String> map = new HashMap<>();
        String orderNumber = OrderNumberUtil.getOrderNumber("KDIQ");
        map.put("OrderCode", orderNumber);
        map.put("ShipperCode", shipperCode);
        map.put("LogisticCode", logisticCode);
        map = getRequestData(map, EXDeliveryConst.InstantQueryRequestType);
        NameValuePair[] nameValuePairs = CommonUtil.mapToNameValuePairs(map);


        String result = NetworkUtil.postRequest(Url, nameValuePairs);
        JSONObject json = JSONObject.fromObject(result);
        InstantQueryResponse response = new InstantQueryResponse(json);
        response.setShipperName(shipperName);
        return response;
    }

    /**
     * 单号识别,为的是识别快递简写
     *
     * @param logisticCode 订单号
     * @return
     * @throws Exception
     */
    public static JSONObject logisticCodeRecognition(String logisticCode) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("LogisticCode", logisticCode);
        map = getRequestData(map, EXDeliveryConst.LogisticCodeRecognitionRequestType);
        String result = NetworkUtil.postRequest(Url, CommonUtil.mapToNameValuePairs(map));
        return JSONObject.fromObject(result);
    }
}

