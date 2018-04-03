package com.rewardshoop.service.impl;

import com.rewardshoop.constants.CommonConst;
import com.rewardshoop.dao.GoodsDetailMapper;
import com.rewardshoop.dao.OrdersDetailMapper;
import com.rewardshoop.daoExt.OrdersDao;
import com.rewardshoop.exception.CustomizeException;
import com.rewardshoop.model.*;
import com.rewardshoop.response.InstantQueryResponse;
import com.rewardshoop.response.OrderDetailResponse;
import com.rewardshoop.response.OrdersResponse;
import com.rewardshoop.response.ResultResponse;
import com.rewardshoop.service.OrderService;
import com.rewardshoop.service.ServiceUtils;
import com.rewardshoop.utils.*;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("OrderService")
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersDao ordersDao;

    @Autowired
    private OrdersDetailMapper ordersDetailMapper;

    @Autowired
    private GoodsDetailMapper goodsDetailMapper;

    @Autowired
    private ServiceUtils serviceUtils;

    @Override
    public List<OrdersResponse> getAllOrdersByUserId(int userId) throws Exception {
        return ordersDao.getAllOrdersByUserId(userId);
    }

    @Override
    public List<OrdersResponse> getUnpaidOrdersByUserId(int userId) throws Exception {
        return ordersDao.getUnpaidOrdersByUserId(userId);
    }

    @Override
    public List<OrdersResponse> getUnacceptedOrdersByUserId(int userId) throws Exception {
        return ordersDao.getUnacceptedOrdersByUserId(userId);
    }

    @Override
    public void insertOrders(int userId, int addId, int totalConsumePoint, int totalPrepayPoint, int goodsId, int payWay, int moneyCount, int num) throws Exception {

        String orderNumber = OrderNumberUtil.getOrderNumber("RS");
        int ordersId = insertOrders(userId, addId, totalConsumePoint, totalPrepayPoint, orderNumber);
        OrdersDetail ordersDetail = new OrdersDetail();
        ordersDetail.setOrdersId(ordersId);
        ordersDetail.setOrderNumber(orderNumber);
        ordersDetail.setGoodsId(goodsId);
        ordersDetail.setPayType(payWay);
        ordersDetail.setNum(num);
        ordersDetail.setMoneyCount(moneyCount);
        ordersDetailMapper.insert(ordersDetail);

    }

    @Override
    public int insertOrders(int userId, int addId, int totalConsumePoint, int totalPrepayPoint, List<OrdersDetail> list) throws Exception {
        int goodsId;
        int num;
        for (OrdersDetail ordersDetail : list) {
            goodsId = ordersDetail.getGoodsId();
            num = ordersDetail.getNum();
            ResultResponse response = serviceUtils.checkOverLimit(userId, goodsId, num);
            if (!response.isState()) {
                throw new CustomizeException(response.getErrMsg());
            }
        }

        String orderNumber = OrderNumberUtil.getOrderNumber("RS");
        int ordersId = insertOrders(userId, addId, totalConsumePoint, totalPrepayPoint, orderNumber);

        for (OrdersDetail ordersDetail : list) {
            ordersDetail.setOrdersId(ordersId);
            ordersDetail.setOrderNumber(orderNumber);
        }

        ordersDao.insertOrdersDetail(list);
        return ordersId;
    }

    /**
     * 插入新订单
     *
     * @param userId
     * @param addId
     * @param totalConsumePoint
     * @param totalPrepayPoint
     * @return
     * @throws Exception
     */
    private int insertOrders(int userId, int addId, int totalConsumePoint, int totalPrepayPoint, String orderNumber) throws Exception {
        Orders orders = new Orders();
        orders.setUserId(userId);
        orders.setAddId(addId);
        orders.setTotalConsumePoint(totalConsumePoint);
        orders.setTotalPrepayPoint(totalPrepayPoint);
        orders.setOrderNumber(orderNumber);
        orders.setAddTime(TimeUtil.currentTime());
        orders.setState(1);
        ordersDao.insertOrders(orders);
        return orders.getId();
    }

    @Override
    public void deleteOrdersById(int id) throws Exception {
        ordersDao.deleteByPrimaryKey(id);
        OrdersDetailExample example = new OrdersDetailExample();
        example.createCriteria().andOrdersIdEqualTo(id);
        ordersDetailMapper.deleteByExample(example);
    }

    @Override
    public void updataOrdersToCancel(int id) throws Exception {
        Orders orders = ordersDao.selectByPrimaryKey(id);
        orders.setState(3);
        orders.setRemark("用户取消");
        ordersDao.updateByPrimaryKey(orders);
    }

    @Override
    public void updataOrdersToConfirm(int id) throws Exception {
        Orders orders = ordersDao.selectByPrimaryKey(id);
        orders.setState(5);
        orders.setSuccessTime(TimeUtil.currentTime());
        orders.setRemark("订单已确认,交易成功");
        ordersDao.updateByPrimaryKey(orders);
    }

    @Override
    public ResultResponse payment(String payPwd, int ordersId) throws CustomizeException {
        Orders orders = ordersDao.selectByPrimaryKey(ordersId);
        String userId = orders.getUserId() + "";
        String totalConsumePoint = orders.getTotalConsumePoint() + "";
        String totalPrepayPoint = orders.getTotalPrepayPoint() + "";
        String orderNumber = orders.getOrderNumber();

        OrdersDetailExample example = new OrdersDetailExample();
        example.createCriteria().andOrdersIdEqualTo(ordersId);
        List<OrdersDetail> list = ordersDetailMapper.selectByExample(example);
        int goodsId;
        int stock;
        int num;
        try {
            for (OrdersDetail ordersDetail : list) {
                goodsId = ordersDetail.getGoodsId();
                GoodsDetailExample goodsDetailExample = new GoodsDetailExample();
                goodsDetailExample.createCriteria().andGoodsIdEqualTo(goodsId);
                GoodsDetail goodsDetail = goodsDetailMapper.selectByExample(goodsDetailExample).get(0);
                stock = goodsDetail.getStock();
                num = ordersDetail.getNum();
                if (num > stock) {
                    throw new CustomizeException("库存只剩下stock件".replace("stock", stock + ""));
                } else {
                    goodsDetail.setStock(stock - num);
                    goodsDetailMapper.updateByPrimaryKey(goodsDetail);
                }
            }
            String url = CommonUtil.stitching(CommonConst.Starshine_Center_Url, "api/withDrawByType");
            Map<String, String> map = new HashMap<>();
            map.put("userId", userId);
            map.put("payPwd", payPwd);
            map.put("totalConsumePoint", totalConsumePoint);
            map.put("totalPrepayPoint", totalPrepayPoint);
            map.put("orderNumber", orderNumber);
            String out = JSONObject.fromObject(map).toString();
            String result = NetworkUtil.httpsRequest(url, "POST", out);
            JSONObject json = JSONObject.fromObject(result);
            boolean flag = json.getBoolean("state");
            if (flag) {
                orders.setPayTime(TimeUtil.currentTime());
                orders.setState(2);
                orders.setRemark("用户已支付");
                ordersDao.updateByPrimaryKey(orders);
                return new ResultResponse(true);
            } else {
                String errMsg = json.getString("errMsg");
                throw new CustomizeException(errMsg);


            }
        } catch (CustomizeException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new ResultResponse(false, e.getMessage());
        }
    }

    @Override
    public OrderDetailResponse getOrdersById(int id) throws Exception {
        OrderDetailResponse detailResponse = ordersDao.getOrdersById(id);
        Integer addTime = detailResponse.getAddTime();
        Integer payTime = detailResponse.getPayTime();
        Integer sucessTime = detailResponse.getSuccessTime();
        detailResponse.setAddDate(TimeUtil.currentTimeToDate(addTime));
        detailResponse.setPayDate(payTime == null ? null : TimeUtil.currentTimeToDate(payTime));
        detailResponse.setSuccessDate(sucessTime == null ? null : TimeUtil.currentTimeToDate(sucessTime));
        return detailResponse;
    }

    @Override
    public InstantQueryResponse getLogisticsInfoByOrderId(int id) throws Exception {
        Orders orders = ordersDao.selectByPrimaryKey(id);
        String logisticsNumber = orders.getLogisticsNumber();
        return EXDeliveryUtil.instantQuery(logisticsNumber);
    }
}
