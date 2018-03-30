package com.rewardshoop.adminController;

import com.rewardshoop.pojo.UserCenterOrdersQueryPojo;
import com.rewardshoop.response.EnjorStarOrdersResponse;
import com.rewardshoop.service.UserCenterOrdersService;
import com.rewardshoop.utils.ExcelUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("UserCenterOrders")
public class UserCenterOrdersController {
    @Autowired
    private UserCenterOrdersService userCenterOrdersService;

    @Value("${EnjoyStar.File.Download}")
    private String downloadFileName;

    /**
     * 填充查询条件
     *
     * @param request
     * @return
     * @throws Exception
     */
    private UserCenterOrdersQueryPojo fillQueryConditions(HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("UTF-8");
        //填充查询条件
        UserCenterOrdersQueryPojo queryPojo = new UserCenterOrdersQueryPojo();
        //订单状态
        String payStatus = request.getParameter("payStatus");
        String addTimeStart = request.getParameter("addTimeStart");
        String addTimeEnd = request.getParameter("addTimeEnd");
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
                    if (example.length() == 18 || example.length() == 24) {
                        queryPojo.setOrderNumber(example);
                    } else
                        //其余按用户姓名算
                        queryPojo.setUserName(example);
        }

        queryPojo.setAddTimeStart(addTimeStart);
        queryPojo.setAddTimeEnd(addTimeEnd);
        queryPojo.setPayStatus(payStatus);

        return queryPojo;
    }

    @RequestMapping("getAllEnjoyStarOrdersListByAdmin")
    public ModelAndView getAllEnjoyStarOrdersListByAdmin(@RequestParam(value = "index", defaultValue = "0") int index, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserCenterOrdersQueryPojo queryPojo = fillQueryConditions(request);
        //翻页就靠距了
        index = StringUtils.isBlank(request.getParameter("index")) ? index : Integer.parseInt(request.getParameter("index"));

        List<EnjorStarOrdersResponse> list = userCenterOrdersService.getAllEnjoyStarOrdersListByAdmin(index, queryPojo);
        int totalPage = userCenterOrdersService.countAllEnjoyStarOrdersListByAdmin(queryPojo);

        mv.setViewName("orders/enjoyStarOrdersList");
        mv.addObject("list", list);
        mv.addObject("totalPage", totalPage);
        mv.addObject("addTimeStart", request.getParameter("addTimeStart"));
        mv.addObject("addTimeEnd", request.getParameter("addTimeEnd"));
        mv.addObject("payStatus", request.getParameter("payStatus"));
        mv.addObject("index", index);
        mv.addObject("example", queryPojo.getExample());
        return mv;
    }

    @RequestMapping(value = "downloadEnjoyStarOrdersListByExample", method = RequestMethod.GET)
    public void downloadEnjoyStarOrdersListByExample(HttpServletRequest request, HttpServletResponse response) throws Exception {

        UserCenterOrdersQueryPojo queryPojo = fillQueryConditions(request);

        List<EnjorStarOrdersResponse> list = userCenterOrdersService.getAllEnjoyStarOrdersListByAdmin(queryPojo);

        ExcelUtil.exportExcel(list, "星享金订单详情", "星享金订单信息", EnjorStarOrdersResponse.class, downloadFileName, response);

    }
}
