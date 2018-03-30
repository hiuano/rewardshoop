package com.rewardshoop.pojo;

import com.rewardshoop.utils.CommonUtil;
import com.rewardshoop.utils.TimeUtil;

public class OrdersAdminQueryPojo {
    private Integer addTimeStart;
    private Integer addTimeEnd;
    private Integer state;
    private String userName;
    private String userPhone;
    private String prepaidCard;
    private String goodsName;
    private String orderNumber;
    private String example;

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getAddTimeStart() {
        return addTimeStart;
    }

    public void setAddTimeStart(String addTimeStart) {
        this.addTimeStart = addTimeStart == null ? null : TimeUtil.dateToCurrent(addTimeStart, "yyyy-MM-dd");
    }

    public Integer getAddTimeEnd() {
        return addTimeEnd;
    }

    public void setAddTimeEnd(String addTimeEnd) {
        this.addTimeEnd = addTimeEnd == null ? null : TimeUtil.dateToCurrent(addTimeEnd, "yyyy-MM-dd");
    }

    public Integer getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? 0 : Integer.parseInt(state);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = CommonUtil.stitching("%", userName, "%");
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getPrepaidCard() {
        return prepaidCard;
    }

    public void setPrepaidCard(String prepaidCard) {
        this.prepaidCard = prepaidCard;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = CommonUtil.stitching("%", goodsName, "%");
    }
}
