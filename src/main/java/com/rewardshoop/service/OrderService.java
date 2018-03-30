package com.rewardshoop.service;

import com.rewardshoop.exception.CustomizeException;
import com.rewardshoop.model.OrdersDetail;
import com.rewardshoop.response.OrderDetailResponse;
import com.rewardshoop.response.OrdersResponse;
import com.rewardshoop.response.ResultResponse;

import java.util.List;

public interface OrderService {
    /**
     * 通过userId获取所有订单信息
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public List<OrdersResponse> getAllOrdersByUserId(int userId) throws Exception;

    /**
     * 查未支付订单
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public List<OrdersResponse> getUnpaidOrdersByUserId(int userId) throws Exception;

    /**
     * 查未收货订单
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public List<OrdersResponse> getUnacceptedOrdersByUserId(int userId) throws Exception;

    /**
     * 单个产品插入订单
     *
     * @param userId
     * @param addId
     * @param totalConsumePoint
     * @param totalPrepayPoint
     * @param goodsId
     * @param payWay
     * @param moneyCount
     * @param num
     * @throws Exception
     */
    public void insertOrders(int userId, int addId, int totalConsumePoint, int totalPrepayPoint, int goodsId, int payWay, int moneyCount, int num) throws Exception;

    /**
     * 购物车新增的订单
     *
     * @param userId
     * @param addId
     * @param totalConsumePoint
     * @param totalPrepayPoint
     * @param list
     * @throws Exception
     */
    public int insertOrders(int userId, int addId, int totalConsumePoint, int totalPrepayPoint, List<OrdersDetail> list) throws Exception;

    /**
     * 根据Id删除订单,包括订单详情
     *
     * @param id
     * @throws Exception
     */
    public void deleteOrdersById(int id) throws Exception;

    /**
     * 取消订单
     *
     * @param id
     * @throws Exception
     */
    public void updataOrdersToCancel(int id) throws Exception;

    /**
     * 确认订单
     *
     * @param id
     * @throws Exception
     */
    public void updataOrdersToConfirm(int id) throws Exception;

    /**
     * 调用会员中心支付接口
     *
     * @param payPwd
     * @param ordersId
     * @return
     * @throws Exception
     */
    public ResultResponse payment(String payPwd, int ordersId) throws CustomizeException;

    /**
     * 获取订单详情
     *
     * @param id
     * @return
     * @throws Exception
     */
    public OrderDetailResponse getOrdersById(int id) throws Exception;
}
