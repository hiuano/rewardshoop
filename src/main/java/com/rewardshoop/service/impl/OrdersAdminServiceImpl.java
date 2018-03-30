package com.rewardshoop.service.impl;

import com.rewardshoop.daoExt.OrdersDao;
import com.rewardshoop.model.Orders;
import com.rewardshoop.model.OrdersStateDesc;
import com.rewardshoop.pojo.OrdersAdminQueryPojo;
import com.rewardshoop.response.OrdersAdminResponse;
import com.rewardshoop.service.OrdersAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ordersAdminService")
@Transactional
public class OrdersAdminServiceImpl implements OrdersAdminService {
    @Autowired
    private OrdersDao ordersDao;

    //分页显示条数
    @Value("${pageSize}")
    private int pageSize;

    public List<OrdersAdminResponse> getAllOrdersListByAdmin(int index, OrdersAdminQueryPojo ordersAdminQueryPojo) throws Exception {
        int startRow = index * pageSize;
        return getAllOrdersListByAdmin(startRow, pageSize, ordersAdminQueryPojo);
    }

    @Override
    public List<OrdersAdminResponse> getAllOrdersListByAdmin(int startRow, int pageSize, OrdersAdminQueryPojo ordersAdminQueryPojo) throws Exception {
        return ordersDao.getAllOrdersListByAdmin(startRow, pageSize, ordersAdminQueryPojo);
    }

    @Override
    public Integer countAllOrdersListByAdmin(OrdersAdminQueryPojo ordersAdminQueryPojo) throws Exception {
        int total = ordersDao.countAllOrdersListByAdmin(0, 0, ordersAdminQueryPojo);
        //总页数
        return total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
    }

    @Override
    public void updateOrdersLogisticsNumberById(int id, String LogisticsNumber) throws Exception {
        Orders orders = ordersDao.selectByPrimaryKey(id);
        orders.setLogisticsNumber(LogisticsNumber);
        orders.setState(4);
        ordersDao.updateByPrimaryKey(orders);
    }

    @Override
    public List<OrdersStateDesc> getOrdersStateDesc() throws Exception {
        return ordersDao.getOrdersStateDesc();
    }
}
