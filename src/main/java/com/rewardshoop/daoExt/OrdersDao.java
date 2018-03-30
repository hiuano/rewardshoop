package com.rewardshoop.daoExt;

import com.rewardshoop.dao.OrdersMapper;
import com.rewardshoop.model.Orders;
import com.rewardshoop.model.OrdersDetail;
import com.rewardshoop.model.OrdersStateDesc;
import com.rewardshoop.pojo.OrdersAdminQueryPojo;
import com.rewardshoop.response.OrderDetailResponse;
import com.rewardshoop.response.OrdersAdminResponse;
import com.rewardshoop.response.OrdersResponse;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 后台获取所有订单,pageSize=0则不限数量
     *
     * @return
     * @throws Exception
     */
    public List<OrdersAdminResponse> getAllOrdersListByAdmin(@Param("startRow") int startRow, @Param("pageSize") int pageSize, @Param("ordersAdminQueryPojo") OrdersAdminQueryPojo ordersAdminQueryPojo) throws Exception;

    /**
     * 获取所有订单的总数,pageSize=0则不限数量
     *
     * @param startRow
     * @param pageSize
     * @param ordersAdminQueryPojo
     * @return
     * @throws Exception
     */
    public Integer countAllOrdersListByAdmin(@Param("startRow") int startRow, @Param("pageSize") int pageSize, @Param("ordersAdminQueryPojo") OrdersAdminQueryPojo ordersAdminQueryPojo) throws Exception;

    /**
     * 查询订单状态描述
     *
     * @return
     * @throws Exception
     */
    public List<OrdersStateDesc> getOrdersStateDesc() throws Exception;
}
