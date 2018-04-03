package com.rewardshoop.response;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class InstantQueryResponse {
    //用户ID
    private String eBusinessID;
    //订单编号
    private String orderNumber;
    //快递公司编码
    private String shipperCode;
    //物流运单号
    private String logisticCode;
    //成功与否
    private boolean success;
    //物流状态：2-在途中,3-签收,4-问题件
    private String state;
    //失败原因
    private String reason;
    //物流信息
    private List<Traces> list;
    //快递公司名称
    private String shipperName;

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public String geteBusinessID() {
        return eBusinessID;
    }

    public void seteBusinessID(String eBusinessID) {
        this.eBusinessID = eBusinessID;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getShipperCode() {
        return shipperCode;
    }

    public void setShipperCode(String shipperCode) {
        this.shipperCode = shipperCode;
    }

    public String getLogisticCode() {
        return logisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        this.logisticCode = logisticCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<Traces> getList() {
        return list;
    }

    public void setList(List<Traces> list) {
        this.list = list;
    }

    public InstantQueryResponse() {
    }

    public InstantQueryResponse(boolean success, String reason) {
        this.success = success;
        this.reason = reason;
    }

    public InstantQueryResponse(JSONObject json) {
        this.eBusinessID = json.getString("EBusinessID");
        this.logisticCode = json.getString("LogisticCode");
        this.orderNumber = json.getString("OrderCode");
        this.success = json.getBoolean("Success");
        this.state = json.getString("State");
        if (!this.success) {
            this.reason = json.getString("Reason");
        }
        JSONArray array = json.getJSONArray("Traces");
        List<Traces> list = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            JSONObject j = array.getJSONObject(i);
            Traces traces = new Traces(j);
            list.add(traces);
        }
        this.list = list;
    }
}

class Traces {
    //时间
    private String acceptTime;
    //描述
    private String acceptStation;
    //备注
    private String remark;

    public String getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getAcceptStation() {
        return acceptStation;
    }

    public void setAcceptStation(String acceptStation) {
        this.acceptStation = acceptStation;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Traces() {
    }

    public Traces(JSONObject json) {
        this.acceptStation = json.getString("AcceptStation");
        this.acceptTime = json.getString("AcceptTime");
        this.remark = json.has("Remark") ? json.getString("Remark") : null;
    }
}