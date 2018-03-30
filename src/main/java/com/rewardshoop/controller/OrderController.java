package com.rewardshoop.controller;

import com.rewardshoop.exception.CustomizeException;
import com.rewardshoop.model.OrdersDetail;
import com.rewardshoop.request.OrdersRequest;
import com.rewardshoop.request.PaymentRequest;
import com.rewardshoop.response.OrderDetailResponse;
import com.rewardshoop.response.OrdersResponse;
import com.rewardshoop.response.ResultResponse;
import com.rewardshoop.service.OrderService;
import com.rewardshoop.validated.Payment;
import com.rewardshoop.validated.insertOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ResponseBody
    @RequestMapping(value = "getOrdersByUserId", method = RequestMethod.GET)
    public ResultResponse getOrdersByUserId(int userId, int type) throws Exception {
        List<OrdersResponse> list;
        if (type == 0) {
            list = orderService.getAllOrdersByUserId(userId);
        } else if (type == 1) {
            list = orderService.getUnpaidOrdersByUserId(userId);
        } else {
            list = orderService.getUnacceptedOrdersByUserId(userId);
        }
        return new ResultResponse(true, list);
    }

    @RequestMapping(value = "insertOrders", method = RequestMethod.POST)
    @ResponseBody
    public ResultResponse insertOrders(@Validated(value = insertOrders.class) @RequestBody OrdersRequest request, BindingResult br) throws Exception {
        if (br.hasErrors()) {
            List<ObjectError> errorList = br.getAllErrors();
            return new ResultResponse(false, errorList.get(0).getDefaultMessage());
        }

        int userId = request.getUserId();
        int addId = request.getAddId();
        int totalConsumePoint = request.getTotalConsumePoint();
        int totalPrepayPoint = request.getTotalPrepayPoint();
        List<OrdersDetail> list = request.getList();
        //限制购买数量,若超出购买限制,service抛异常,controller捕捉
        try {
            int ordersId = orderService.insertOrders(userId, addId, totalConsumePoint, totalPrepayPoint, list);
            return new ResultResponse(true, ordersId);
        } catch (CustomizeException e) {
            String errMsg = e.getMessage();
            return new ResultResponse(false, errMsg);
        }

    }

    @RequestMapping(value = "deleteOrdersById", method = RequestMethod.POST)
    @ResponseBody
    public ResultResponse deleteOrdersById(@RequestBody OrdersRequest request) throws Exception {
        int id = request.getId();
        orderService.deleteOrdersById(id);
        return new ResultResponse(true);
    }

    @RequestMapping(value = "updataOrdersToCancel", method = RequestMethod.POST)
    @ResponseBody
    public ResultResponse updataOrdersToCancel(@RequestBody OrdersRequest request) throws Exception {
        int id = request.getId();
        orderService.updataOrdersToCancel(id);
        return new ResultResponse(true);
    }

    @ResponseBody
    @RequestMapping(value = "updataOrdersToConfirm", method = RequestMethod.POST)
    public ResultResponse updataOrdersToConfirm(@RequestBody OrdersRequest request) throws Exception {
        int id = request.getId();
        orderService.updataOrdersToConfirm(id);
        return new ResultResponse(true);

    }

    /**
     * 调用外部支付接口
     *
     * @param request
     * @param br
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "payment", method = RequestMethod.POST)
    public ResultResponse payment(@RequestBody @Validated(value = Payment.class) PaymentRequest request, BindingResult br) throws Exception {
        if (br.hasErrors()) {
            List<ObjectError> errorList = br.getAllErrors();
            return new ResultResponse(false, errorList.get(0).getDefaultMessage());
        }
        String payPwd = request.getPayPwd();
        int ordersId = request.getOrdersId();
        return orderService.payment(payPwd, ordersId);

    }

    @ResponseBody
    @RequestMapping(value = "getOrdersById", method = RequestMethod.GET)
    public ResultResponse getOrdersById(int id) throws Exception {
        OrderDetailResponse orderDetailResponse = orderService.getOrdersById(id);
        return new ResultResponse(true, orderDetailResponse);
    }
}
