package com.rewardshoop.model;

public class Cart {
    private Integer id;

    private Integer userId;

    private Integer goodsId;

    private Integer num;

    private Integer payWay;

    private Integer point;

    private String addTime;

    private String updateTime;

    public Cart(Integer id, Integer userId, Integer goodsId, Integer num, Integer payWay, Integer point, String addTime, String updateTime) {
        this.id = id;
        this.userId = userId;
        this.goodsId = goodsId;
        this.num = num;
        this.payWay = payWay;
        this.point = point;
        this.addTime = addTime;
        this.updateTime = updateTime;
    }

    public Cart() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}