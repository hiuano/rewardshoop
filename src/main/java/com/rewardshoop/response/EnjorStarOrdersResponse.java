package com.rewardshoop.response;

import com.rewardshoop.utils.TimeUtil;
import org.jeecgframework.poi.excel.annotation.Excel;

public class EnjorStarOrdersResponse {
    private Integer id;
    @Excel(name = "订单号", width = 28)
    private String orderNumber;
    @Excel(name = "下单时间", width = 26)
    private String addTime;
    @Excel(name = "支付状态", width = 12)
    private Integer payStatus;
    @Excel(name = "用户名", width = 13)
    private String userName;
    @Excel(name = "用户电话", width = 16)
    private String userPhone;
    @Excel(name = "预付卡号", width = 25)
    private String prepaidCard;
    @Excel(name = "名称", width = 15)
    private String goodsTitle;
    @Excel(name = "购买数量")
    private Integer buyNum;
    @Excel(name = "提现金额", width = 12)
    private Integer moneyCount;
    @Excel(name = "积分兑换金额", width = 14)
    private Integer integralDeductible;
    @Excel(name = "佣金", width = 12)
    private Integer commission;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = TimeUtil.currentTimeToDate(addTime);
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
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

    public Integer getMoneyCount() {
        return moneyCount;
    }

    public void setMoneyCount(Integer moneyCount) {
        this.moneyCount = moneyCount;
    }

    public Integer getIntegralDeductible() {
        return integralDeductible;
    }

    public void setIntegralDeductible(Integer integralDeductible) {
        this.integralDeductible = integralDeductible;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }
}
