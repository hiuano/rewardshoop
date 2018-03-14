package com.rewardshoop.model;

public class Orders {
    private Integer id;

    private String orderNumber;

    private Integer userId;

    private Integer addTime;

    private Integer payTime;

    private Integer successTime;

    private Integer addId;

    private Integer state;

    private Integer totalConsumePoint;

    private Integer totalPrepayPoint;

    private String logisticsNumber;

    private String remark;

    public Orders(Integer id, String orderNumber, Integer userId, Integer addTime, Integer payTime, Integer successTime, Integer addId, Integer state, Integer totalConsumePoint, Integer totalPrepayPoint, String logisticsNumber, String remark) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.userId = userId;
        this.addTime = addTime;
        this.payTime = payTime;
        this.successTime = successTime;
        this.addId = addId;
        this.state = state;
        this.totalConsumePoint = totalConsumePoint;
        this.totalPrepayPoint = totalPrepayPoint;
        this.logisticsNumber = logisticsNumber;
        this.remark = remark;
    }

    public Orders() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Integer getPayTime() {
        return payTime;
    }

    public void setPayTime(Integer payTime) {
        this.payTime = payTime;
    }

    public Integer getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Integer successTime) {
        this.successTime = successTime;
    }

    public Integer getAddId() {
        return addId;
    }

    public void setAddId(Integer addId) {
        this.addId = addId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getTotalConsumePoint() {
        return totalConsumePoint;
    }

    public void setTotalConsumePoint(Integer totalConsumePoint) {
        this.totalConsumePoint = totalConsumePoint;
    }

    public Integer getTotalPrepayPoint() {
        return totalPrepayPoint;
    }

    public void setTotalPrepayPoint(Integer totalPrepayPoint) {
        this.totalPrepayPoint = totalPrepayPoint;
    }

    public String getLogisticsNumber() {
        return logisticsNumber;
    }

    public void setLogisticsNumber(String logisticsNumber) {
        this.logisticsNumber = logisticsNumber == null ? null : logisticsNumber.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}