package com.rewardshoop.response;

import com.rewardshoop.utils.TimeUtil;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;
import org.jeecgframework.poi.excel.annotation.ExcelTarget;

import java.util.List;

@ExcelTarget("ordersAdminResponse")
public class OrdersAdminResponse {
    private int id;
    @Excel(name = "下单时间", needMerge = true, width = 20)
    private String addTime;
    @Excel(name = "支付时间", needMerge = true, width = 20)
    private String payTime;
    @Excel(name = "交易成功时间", needMerge = true, width = 20)
    private String successTiome;
    @Excel(name = "订单号", needMerge = true, width = 26)
    private String orderNumber;
    @Excel(name = "物流单号", width = 20)
    private String logisticsNumber;
    @Excel(name = "订单状态", width = 12, needMerge = true, replace = {"未支付_1", "已支付_2", "已取消_3", "已发货_4", "交易成功_5"})
    private int state;
    @Excel(name = "消费积分(单位:分)", width = 16, needMerge = true)
    private int totalConsumePoint;
    @Excel(name = "预付积分(单位:分)", width = 16, needMerge = true)
    private int totalPrepayPoint;
    @Excel(name = "用户姓名", needMerge = true)
    private String userName;
    @Excel(name = "用户电话", width = 15, needMerge = true)
    private String userPhone;
    @Excel(name = "预付卡", width = 23, needMerge = true)
    private String prepaidCard;
    @Excel(name = "省", needMerge = true)
    private String province;
    @Excel(name = "市", needMerge = true)
    private String city;
    @Excel(name = "区", needMerge = true)
    private String area;
    @Excel(name = "街道", needMerge = true)
    private String strees;
    @Excel(name = "详细地址", width = 35, needMerge = true)
    private String description;
    @Excel(name = "收货人姓名", width = 11, needMerge = true)
    private String addName;
    @Excel(name = "收货人电话", width = 15, needMerge = true)
    private String addPhone;
    @ExcelCollection(name = "商品信息")
    private List<OrdersAdminGoods> list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(int addTime) {

        this.addTime = TimeUtil.currentTimeToDate(addTime);
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(int payTime) {
        this.payTime = TimeUtil.currentTimeToDate(payTime);
    }

    public String getSuccessTiome() {
        return successTiome;
    }

    public void setSuccessTiome(int successTiome) {
        this.successTiome = TimeUtil.currentTimeToDate(successTiome);
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getLogisticsNumber() {
        return logisticsNumber;
    }

    public void setLogisticsNumber(String logisticsNumber) {
        this.logisticsNumber = logisticsNumber;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStrees() {
        return strees;
    }

    public void setStrees(String strees) {
        this.strees = strees;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddName() {
        return addName;
    }

    public void setAddName(String addName) {
        this.addName = addName;
    }

    public String getAddPhone() {
        return addPhone;
    }

    public void setAddPhone(String addPhone) {
        this.addPhone = addPhone;
    }


    public List<OrdersAdminGoods> getList() {
        return list;
    }

    public void setList(List<OrdersAdminGoods> list) {
        this.list = list;
    }
}


