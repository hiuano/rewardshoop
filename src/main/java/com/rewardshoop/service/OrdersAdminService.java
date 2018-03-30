package com.rewardshoop.service;

import com.rewardshoop.model.OrdersStateDesc;
import com.rewardshoop.pojo.OrdersAdminQueryPojo;
import com.rewardshoop.response.OrdersAdminResponse;

import java.util.List;

public interface OrdersAdminService {
    public List<OrdersAdminResponse> getAllOrdersListByAdmin(int index, OrdersAdminQueryPojo ordersAdminQueryPojo) throws Exception;

    public List<OrdersAdminResponse> getAllOrdersListByAdmin(int startRow, int pageSize, OrdersAdminQueryPojo ordersAdminQueryPojo) throws Exception;

    public Integer countAllOrdersListByAdmin(OrdersAdminQueryPojo ordersAdminQueryPojo) throws Exception;

    public void updateOrdersLogisticsNumberById(int id, String LogisticsNumber) throws Exception;

    public List<OrdersStateDesc> getOrdersStateDesc()throws Exception;
}
