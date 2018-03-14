package com.rewardshoop.daoExt;

import com.rewardshoop.dao.OrdersMapper;
import com.rewardshoop.model.Orders;
import com.rewardshoop.model.OrdersDetail;
import com.rewardshoop.response.OrderDetailResponse;
import com.rewardshoop.response.OrdersResponse;

import java.util.List;

public interface OrdersDao extends OrdersMapper {

    /**
     * 通过userId查订单信息
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public List<OrdersResponse> getAllOrdersByUserId(int userId) throws Exception;

    /**
     * 通过userId查未支付订单信息
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public List<OrdersResponse> getUnpaidOrdersByUserId(int userId) throws Exception;

    /**
     * 通过userId查待收货订单信息
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public List<OrdersResponse> getUnacceptedOrdersByUserId(int userId) throws Exception;

    /**
     * 新建订单
     *
     * @param orders
     * @throws Exception
     */
    public void insertOrders(Orders orders) throws Exception;

    /**
     * 新建订单详情
     *
     * @param list
     * @throws Exception
     */
    public void insertOrdersDetail(List<OrdersDetail> list) throws Exception;

    /**
     * 获取订单详情,其实也就比获取所有订单多了一个物流单号
     *
     * @param id
     * @return
     * @throws Exception
     */
    public OrderDetailResponse getOrdersById(int id) throws Exception;
}
