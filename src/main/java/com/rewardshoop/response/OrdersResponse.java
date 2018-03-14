package com.rewardshoop.response;

import java.util.List;

public class OrdersResponse {
    private int id;
    private String orderNumber;
    private String stateDesc;
    private int state;
    private int totalConsumePoint;
    private int totalPrepayPoint;
    private String logisticsNumber;
    private List<OrdersGoods> goods;

    public String getLogisticsNumber() {
        return logisticsNumber;
    }

    public void setLogisticsNumber(String logisticsNumber) {
        this.logisticsNumber = logisticsNumber;
    }

    public int getTotalConsumePoint() {
        return totalConsumePoint;
    }

    public void setTotalConsumePoint(int totalConsumePoint) {
        this.totalConsumePoint = totalConsumePoint;
    }

    public int getTotalPrepayPoint() {
        return totalPrepayPoint;
    }

    public void setTotalPrepayPoint(int totalPrepayPoint) {
        this.totalPrepayPoint = totalPrepayPoint;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStateDesc() {
        return stateDesc;
    }

    public void setStateDesc(String stateDesc) {
        this.stateDesc = stateDesc;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<OrdersGoods> getGoods() {
        return goods;
    }

    public void setGoods(List<OrdersGoods> goods) {
        this.goods = goods;
    }
}

class OrdersGoods {
    private int id;
    private String pic;
    private int payWay;
    private String payWayDesc;
    private int num;
    private int pointCount;
    private String goodsName;
    private int typeId;
    private String typeName;
    private int consumePoint;
    private int prepayPoint;


    public int getPayWay() {
        return payWay;
    }

    public void setPayWay(int payWay) {
        this.payWay = payWay;
    }

    public String getPayWayDesc() {
        return payWayDesc;
    }

    public void setPayWayDesc(String payWayDesc) {
        this.payWayDesc = payWayDesc;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPointCount() {
        return pointCount;
    }

    public void setPointCount(int pointCount) {
        this.pointCount = pointCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }


    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getConsumePoint() {
        return consumePoint;
    }

    public void setConsumePoint(int consumePoint) {
        this.consumePoint = consumePoint;
    }

    public int getPrepayPoint() {
        return prepayPoint;
    }

    public void setPrepayPoint(int prepayPoint) {
        this.prepayPoint = prepayPoint;
    }
}
