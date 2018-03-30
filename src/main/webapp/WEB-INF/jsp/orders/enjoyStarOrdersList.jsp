<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: Sven
  Date: 2018/3/21
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();%>
<html>

<head>
    <meta charset="utf-8"/>
    <title>后台管理系统</title>
    <meta name="author" content="DeathGhost"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css">
    <!--[if lt IE 9]>
    <script src="<%=path%>/js/html5.js"></script>
    <![endif]-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
    <script src="<%=path%>/js/jquery.js"></script>
    <script src="<%=path%>/js/jquery.mCustomScrollbar.concat.min.js"></script>

    <%-- 时间选择器 --%>
    <script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>


    <script>

        (function ($) {
            $(window).load(function () {

                $("a[rel='load-content']").click(function (e) {
                    e.preventDefault();
                    var url = $(this).attr("href");
                    $.get(url, function (data) {
                        $(".content .mCSB_container").append(data); //load new content inside .mCSB_container
                        //scroll-to appended content
                        $(".content").mCustomScrollbar("scrollTo", "h2:last");
                    });
                });

                $(".content").delegate("a[href='top']", "click", function (e) {
                    e.preventDefault();
                    $(".content").mCustomScrollbar("scrollTo", $(this).attr("href"));
                });

                //这里控制状态的默认选择
                $("#payStatus").val(${payStatus});
                //这里控制翻页的默认选择
                $("#index").val(${index});
            });
        })(jQuery);
    </script>
    <script language=javascript type="text/javascript">
        /**
         * 下载函数
         */
        function download() {
            form.action = "<%=path%>/UserCenterOrders/downloadEnjoyStarOrdersListByExample";
            form.submit();
        }

        /**
         * 条件查询
         */
        function query() {
            form.action = "<%=path%>/UserCenterOrders/getAllEnjoyStarOrdersListByAdmin";
            form.submit();
        }

        /**
         * 更新订单状态
         */
        function updateOrderState(id, value) {
            console.log(id);
            console.log(value);
            $.post(
                "<%=path%>/UserCenterOrders/updateOrdersLogisticsNumberById",
                {
                    id: id,
                    logisticsNumber: value
                }
            )
        }

        /**
         * 翻页
         * @param index
         */
        function intoPage(index) {
            $("#index")[0].value = index;
            form.action = "<%=path%>/UserCenterOrders/getAllEnjoyStarOrdersListByAdmin";
            form.submit();
        }
    </script>
</head>
<body>


<form name="form" method="get" action="#">
    <section class="rt_wrap content mCustomScrollbar">
        <div class="rt_content">
            <div class="page_title">
                <h2 class="fl">订单列表</h2>
                <a class="fr top_rt_btn add_icon">添加商品</a>
            </div>
            <section class="mtb">
                <select id="payStatus" name="payStatus" class="select">
                    <option value="0">所有订单</option>
                    <option value="1">已支付</option>
                    <option value="2">未支付</option>
                </select>
                <input type="text" class="textbox textbox_225" name="example" value="${example}"
                       placeholder="输入订单编号或用户名/电话/预付卡号"/>
                <br/>

                <input style="margin: 15px" class="textbox textbox_225" id="addTimeStart" name="addTimeStart"
                       placeholder="订单起始时间" value="${addTimeStart}"
                       type="text" onClick="WdatePicker()"/>
                <input style="margin: 15px" class="textbox textbox_225" id="addTimeEnd" name="addTimeEnd" type="text"
                       placeholder="订单结束时间" value="${addTimeEnd}"
                       onClick="WdatePicker()"/>

                <br/>
                <input type="button" value="查询" class="group_btn" onclick="query()"/>

                <input type="button" value="下载" class="group_btn" onclick="download()"/>

            </section>
            <table class="table">
                <tr>
                    <th style="width: 16%">订单编号</th>
                    <th style="width: 6%">订单状态</th>
                    <th style="width: 9%">用户名</th>
                    <th style="width: 9%">用户电话</th>
                    <th style="width: 14%">预付卡号</th>
                    <th style="width: 10%">名称</th>
                    <th style="width: 6%;">购买数量</th>
                    <th style="width: 10%">提现金额</th>
                    <th style="width: 10%">积分兑换金额</th>
                    <th style="width: 10%">佣金</th>
                </tr>
                <c:forEach items="${list }" var="orderList" varStatus="status">

                    <tr>
                        <td class="center">${orderList.orderNumber}</td>
                        <td class="center">
                            <c:if test="${orderList.payStatus==1}"> 已支付</c:if>
                            <c:if test="${orderList.payStatus==2}"> 未支付</c:if>
                        </td>
                        <td class="center">${orderList.userName}</td>
                        <td class="center">${orderList.userPhone}</td>
                        <td class="center">${orderList.prepaidCard}</td>
                        <td class="center">${orderList.goodsTitle}</td>
                        <td class="center">${orderList.buyNum}</td>
                        <td class="center">
                            <strong class="rmb_icon">${orderList.moneyCount}</strong>
                        </td>
                        <td class="center">
                            <strong class="rmb_icon">${orderList.integralDeductible}</strong>
                        </td>
                        <td class="center">
                            <strong class="rmb_icon">${orderList.commission}</strong>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <aside class="paging">
                <%--控制翻页属性--%>
                <a onclick="intoPage(0)">首页</a>
                <a onclick="intoPage(${index-1})">上一页</a>
                <select id="index" name="index" onchange="intoPage(this.value)">
                    <c:forEach var="index" begin="1" end="${totalPage}">
                        <option value="${index-1}">第${index}页</option>
                    </c:forEach>
                </select>
                <a onclick="intoPage(${index+1})">下一页</a>
                <a onclick="intoPage(${totalPage-1})">尾页</a>
            </aside>
        </div>
    </section>
</form>
</body>
</html>
