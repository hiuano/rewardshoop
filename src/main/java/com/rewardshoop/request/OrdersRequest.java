package com.rewardshoop.request;

import com.rewardshoop.model.OrdersDetail;
import com.rewardshoop.validated.insertOrders;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class OrdersRequest {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull(message = "{NOT_NULL}", groups = insertOrders.class)
    private Integer userId;
    @NotNull(message = "{NOT_NULL}", groups = insertOrders.class)
    private Integer addId;
    @NotNull(message = "{NOT_NULL}", groups = insertOrders.class)
    private Integer totalConsumePoint;
    @NotNull(message = "{NOT_NULL}", groups = insertOrders.class)
    private Integer totalPrepayPoint;

    @NotEmpty(message = "{NOT_NULL}", groups = insertOrders.class)
    private List<OrdersDetail> list;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAddId() {
        return addId;
    }

    public void setAddId(Integer addId) {
        this.addId = addId;
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

    public List<OrdersDetail> getList() {
        return list;
    }

    public void setList(List<OrdersDetail> list) {
        this.list = list;
    }
}
