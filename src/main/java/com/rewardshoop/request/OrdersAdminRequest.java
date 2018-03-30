package com.rewardshoop.request;

import com.rewardshoop.validated.updateOrdersLogisticsNumberById;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class OrdersAdminRequest {

    @NotNull(message = "orderID不能为空", groups = updateOrdersLogisticsNumberById.class)
    private Integer id;
    @NotBlank(message = "物流信息不能为空", groups = updateOrdersLogisticsNumberById.class)
    private String logisticsNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogisticsNumber() {
        return logisticsNumber;
    }

    public void setLogisticsNumber(String logisticsNumber) {
        this.logisticsNumber = logisticsNumber;
    }
}
