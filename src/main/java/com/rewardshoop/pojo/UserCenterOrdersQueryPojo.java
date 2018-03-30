package com.rewardshoop.pojo;

import com.rewardshoop.utils.CommonUtil;
import com.rewardshoop.utils.TimeUtil;

public class UserCenterOrdersQueryPojo {
    private Integer addTimeStart;
    private Integer addTimeEnd;
    private String userName;
    private String userPhone;
    private String prepaidCard;
    private Integer payStatus;
    private String orderNumber;
    private String example;

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
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
        this.userPhone = CommonUtil.stitching("%", userPhone, "%");
    }

    public String getPrepaidCard() {
        return prepaidCard;
    }

    public void setPrepaidCard(String prepaidCard) {
        this.prepaidCard = CommonUtil.stitching("%", prepaidCard, "%");
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? 0 : Integer.parseInt(payStatus);
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = CommonUtil.stitching("%", orderNumber, "%");
    }
}
