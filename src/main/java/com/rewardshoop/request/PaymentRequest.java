package com.rewardshoop.request;

import com.rewardshoop.validated.Payment;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class PaymentRequest {
    private String userId;

    @NotNull(message = "{NOT_NULL}", groups = Payment.class)
    @Length(min = 6, max = 6, message = "{PASSWORD_MUST_SIX}", groups = Payment.class)
    private String payPwd;

    private String totalConsumePoint;

    private String totalPrepayPoint;

    @NotNull(message = "{NOT_NULL}", groups = Payment.class)
    private Integer ordersId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPayPwd() {
        return payPwd;
    }

    public void setPayPwd(String payPwd) {
        this.payPwd = payPwd;
    }

    public String getTotalConsumePoint() {
        return totalConsumePoint;
    }

    public void setTotalConsumePoint(String totalConsumePoint) {
        this.totalConsumePoint = totalConsumePoint;
    }

    public String getTotalPrepayPoint() {
        return totalPrepayPoint;
    }

    public void setTotalPrepayPoint(String totalPrepayPoint) {
        this.totalPrepayPoint = totalPrepayPoint;
    }

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }
}
