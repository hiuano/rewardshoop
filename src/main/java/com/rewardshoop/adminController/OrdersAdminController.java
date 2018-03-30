package com.rewardshoop.adminController;

import com.rewardshoop.model.OrdersStateDesc;
import com.rewardshoop.pojo.OrdersAdminQueryPojo;
import com.rewardshoop.request.OrdersAdminRequest;
import com.rewardshoop.response.OrdersAdminResponse;
import com.rewardshoop.service.OrdersAdminService;
import com.rewardshoop.utils.ExcelUtil;
import com.rewardshoop.validated.updateOrdersLogisticsNumberById;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("ordersAdmin")
public class OrdersAdminController {
    @Autowired
    private OrdersAdminService ordersAdminService;

    @Value("${File.Download}")
    private String downloadFileName;

    /**
     * 填充查询条件
     *
     * @param request
     * @return
     * @throws Exception
     */
    private OrdersAdminQueryPojo fillQueryConditions(HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("UTF-8");
        //填充查询条件
        OrdersAdminQueryPojo queryPojo = new OrdersAdminQueryPojo();
        //订单状态
        String state = request.getParameter("state");
        String addTimeStart = request.getParameter("addTimeStart");
        String addTimeEnd = request.getParameter("addTimeEnd");
        String goodsName = request.getParameter("goodsName");
        String example = request.getParameter("example");
        if (StringUtils.isNotBlank(example)) {
            example = new String(example.getBytes("ISO-8859-1"), "UTF-8");
            queryPojo.setExample(example);
            //长度11位,是电话号码
            if (example.length() == 11) {
                queryPojo.setUserPhone(example);
            } else
                //长度19位,是预付卡号码
                if (example.length() == 19) {
                    queryPojo.setPrepaidCard(example);
                } else
                    //长度18位,是订单号
                    if (example.length() == 18) {
                        queryPojo.setOrderNumber(example);
                    } else
                        //长度小于5位,是用户姓名
                        if (example.length() <= 5) {
                            queryPojo.setUserName(example);
                        }
        }

        if (StringUtils.isNotBlank(goodsName)) {
            goodsName = new String(goodsName.getBytes("ISO-8859-1"), "UTF-8");
            queryPojo.setGoodsName(goodsName);
        }
        queryPojo.setAddTimeStart(addTimeStart);
        queryPojo.setAddTimeEnd(addTimeEnd);
        queryPojo.setState(state);

        return queryPojo;
    }

    /**
     * 获取所有订单
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getAllOrdersListByAdmin", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView getAllOrdersListByAdmin(HttpServletRequest request, HttpServletResponse response,
                                                @RequestParam(value = "index", defaultValue = "0") int index) throws Exception {
        ModelAndView mv = new ModelAndView();

        //翻页就靠距了
        index = StringUtils.isBlank(request.getParameter("index")) ? index : Integer.parseInt(request.getParameter("index"));

        OrdersAdminQueryPojo queryPojo = fillQueryConditions(request);

        List<OrdersAdminResponse> list = ordersAdminService.getAllOrdersListByAdmin(index, queryPojo);
        List<OrdersStateDesc> stateDescList = ordersAdminService.getOrdersStateDesc();
        //总页数
        int totalPage = ordersAdminService.countAllOrdersListByAdmin(queryPojo);

        //数据回显
        mv.addObject("list", list);
        mv.addObject("stateDescList", stateDescList);
        mv.addObject("totalPage", totalPage);
        mv.addObject("addTimeStart", request.getParameter("addTimeStart"));
        mv.addObject("addTimeEnd", request.getParameter("addTimeEnd"));
        mv.addObject("state", request.getParameter("state"));
        mv.addObject("example", queryPojo.getExample());
        mv.addObject("goodsName", queryPojo.getGoodsName());
        mv.addObject("index", index);
        mv.setViewName("orders/ordersList");
        return mv;
    }

    @RequestMapping(value = "downloadOrdersListByExample", method = RequestMethod.GET)
    public void downloadOrdersListByExample(HttpServletRequest request, HttpServletResponse response) throws Exception {

        OrdersAdminQueryPojo queryPojo = fillQueryConditions(request);

        List<OrdersAdminResponse> list = ordersAdminService.getAllOrdersListByAdmin(0, 0, queryPojo);

        ExcelUtil.exportExcel(list, "订单详情", "订单信息", OrdersAdminResponse.class, downloadFileName, response);

    }

    @RequestMapping(value = "updateOrdersLogisticsNumberById", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public void updateOrdersLogisticsNumberById(HttpServletRequest request, HttpServletResponse response, @Validated(value = updateOrdersLogisticsNumberById.class) OrdersAdminRequest ordersAdminRequest, BindingResult br) throws Exception {
        if (!br.hasErrors()) {
            int id = ordersAdminRequest.getId();
            String logisticsNumber = ordersAdminRequest.getLogisticsNumber();
            ordersAdminService.updateOrdersLogisticsNumberById(id, logisticsNumber);
        }
    }

    @RequestMapping(value = "getOrdersDetailByOrdersId", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public ModelAndView getOrdersDetailByOrdersId(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/orders/ordersDetail");
        return mv;
    }
}
