package com.rewardshoop.response;

import org.jeecgframework.poi.excel.annotation.Excel;

public class OrdersAdminGoods {
    private int id;
    private int ordersId;
    @Excel(name = "商品总积分", width = 16)
    private int moneyCount;
    @Excel(name = "购买数量")
    private int num;
    @Excel(name = "支付方式", replace = {"消费积分_0", "预付积分_1"})
    private int payType;
    private int goodsId;
    @Excel(name = "商品名字", width = 40)
    private String goodsName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
    }

    public int getMoneyCount() {
        return moneyCount;
    }

    public void setMoneyCount(int moneyCount) {
        this.moneyCount = moneyCount;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }


}
