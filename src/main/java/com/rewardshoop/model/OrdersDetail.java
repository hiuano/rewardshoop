package com.rewardshoop.model;

public class OrdersDetail {
    private Integer id;

    private Integer ordersId;

    private String orderNumber;

    private Integer goodsId;

    private Integer payType;

    private Integer moneyCount;

    private Integer num;

    public OrdersDetail(Integer id, Integer ordersId, String orderNumber, Integer goodsId, Integer payType, Integer moneyCount, Integer num) {
        this.id = id;
        this.ordersId = ordersId;
        this.orderNumber = orderNumber;
        this.goodsId = goodsId;
        this.payType = payType;
        this.moneyCount = moneyCount;
        this.num = num;
    }

    public OrdersDetail() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getMoneyCount() {
        return moneyCount;
    }

    public void setMoneyCount(Integer moneyCount) {
        this.moneyCount = moneyCount;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}