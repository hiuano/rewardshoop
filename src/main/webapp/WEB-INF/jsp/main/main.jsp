<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sven
  Date: 2018/3/21
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>星光珠宝积分商城管理系统</title>
    <meta name="keywords" content="星光珠宝"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css">
    <!--[if lt IE 9]>
    <script src="<%=path%>/js/html5.js"></script>
    <![endif]-->
    <script src="<%=path%>/js/jquery.js"></script>
    <script src="<%=path%>/js/jquery.mCustomScrollbar.concat.min.js"></script>
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

            });
        })(jQuery);
    </script>

    <script language="JavaScript" type="text/javascript">
        let idName = '';

        function changeClass(id) {
            if (idName !== '') {
                let element = document.getElementById(idName);
                element.className = element.className.replace("active", " ");
            }
            document.getElementById(id).className += " " + "active";
            idName = id;
        }
    </script>
</head>
<body>
<!--header-->
<header>
    <h1><img src="<%=path%>/images/admin_logo.png"/></h1>
    <ul class="rt_nav">
        <%--<li><a href="#" target="_blank" class="website_icon">站点首页</a></li>--%>
        <li><a href="#" class="clear_icon">清除缓存</a></li>
        <li><a href="#" class="admin_icon">DeathGhost</a></li>
        <li><a href="#" class="set_icon">账号设置</a></li>
        <li><a href="<%=path%>/loginAdmin/signOut" class="quit_icon">安全退出</a></li>
    </ul>
</header>
<!--aside nav-->
<!--aside nav-->
<aside class="lt_aside_nav content mCustomScrollbar">
    <h2><a href="#">起始页</a></h2>
    <ul>
        <li>
            <dl>
                <dt>常用布局示例</dt>
                <!--当前链接则添加class:active-->
                <dd><a href="product_list.html">商品列表示例</a></dd>
                <dd><a href="product_detail.html">商品详情示例</a></dd>
                <dd><a href="recycle_bin.html">商品回收站示例</a></dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>订单信息</dt>
                <dd><a id="ordersList" onclick="changeClass(this.id)"
                       href="<%=path%>/ordersAdmin/getAllOrdersListByAdmin" target="myframe">订单列表</a>
                </dd>
                <dd><a id="enjoyStarOrdersList" onclick="changeClass(this.id)"
                       href="<%=path%>/UserCenterOrders/getAllEnjoyStarOrdersListByAdmin"
                       target="myframe">星享金订单列表</a>
                </dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>会员管理</dt>
                <dd><a href="user_list.html">会员列表示例</a></dd>
                <dd><a href="user_detail.html">添加会员（详情）示例</a></dd>
                <dd><a href="user_rank.html">会员等级示例</a></dd>
                <dd><a href="adjust_funding.html">会员资金管理示例</a></dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>基础设置</dt>
                <dd><a href="setting.html">站点基础设置示例</a></dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>配送与支付设置</dt>
                <dd><a href="express_list.html">配送方式</a></dd>
                <dd><a href="pay_list.html">支付方式</a></dd>
            </dl>
        </li>
        <li>
            <dl>
                <dt>在线统计</dt>
                <dd><a href="discharge_statistic.html">流量统计</a></dd>
                <dd><a href="sales_volume.html">销售额统计</a></dd>
            </dl>
        </li>
    </ul>
</aside>

    <iframe id="myframe" name="myframe" width="100%" height="100%" frameborder="0">
    </iframe>
<style>
    .dataStatistic {
        width: 400px;
        height: 200px;
        border: 1px solid #ccc;
        margin: 0 auto;
        margin: 10px;
        overflow: hidden
    }

    #cylindrical {
        width: 400px;
        height: 200px;
        margin-top: -15px
    }

    #line {
        width: 400px;
        height: 200px;
        margin-top: -15px
    }

    #pie {
        width: 400px;
        height: 200px;
        margin-top: -15px
    }
</style>


</body>
</html>

