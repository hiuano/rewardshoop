<%--
  Created by IntelliJ IDEA.
  User: Sven
  Date: 2018/3/28
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>订单详情页</title>
    <meta name="author" content="DeathGhost"/>
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
    </script
<body>
<form>
    <section class="rt_wrap content mCustomScrollbar">
        <div class="rt_content">
            <div class="page_title">
                <h2 class="fl">订单详情示例</h2>
            </div>
            <table class="table">
                <tr>
                    <td>收件人：DeathGhost</td>
                    <td>联系电话：18300000000</td>
                    <td>收件地址：陕西省西安市雁塔区丈八路2000集都市印象18栋2160室</td>
                    <td>付款时间：2016-02-01 13:56</td>
                </tr>
                <tr>
                    <td>下单时间：2016-02-01 13:56</td>
                    <td>付款时间：2016-02-01 13:56</td>
                    <td>确认时间：2016-02-01 13:56</td>
                    <td>评价时间时间：---</td>
                </tr>
                <tr>
                    <td>订单状态：<a>已付款，待发货</a></td>
                    <td colspan="3">订单备注：
                        <mark>帮我检查好呀~谢谢~</mark>
                    </td>
                </tr>
            </table>
            <table class="table">
                <tr>
                    <td class="center"><img src="upload/goods01.jpg" width="50" height="50"/></td>
                    <td>这里是产品名称</td>
                    <td class="center">A15902</td>
                    <td class="center"><strong class="rmb_icon">59.00</strong></td>
                    <td class="center">
                        <p>颜色：蓝色</p>
                        <p>尺码：XXL码</p>
                    </td>
                    <td class="center"><strong>1</strong></td>
                    <td class="center"><strong class="rmb_icon">59.00</strong></td>
                    <td class="center">包</td>
                </tr>
                <tr>
                    <td class="center"><img src="upload/goods02.jpg" width="50" height="50"/></td>
                    <td>这里是产品名称</td>
                    <td class="center">A15902</td>
                    <td class="center"><strong class="rmb_icon">59.00</strong></td>
                    <td class="center">
                        <p>颜色：蓝色</p>
                        <p>尺码：XXL码</p>
                    </td>
                    <td class="center"><strong>2</strong></td>
                    <td class="center"><strong class="rmb_icon">118.00</strong></td>
                    <td class="center">包</td>
                </tr>
                <tr>
                    <td class="center"><img src="upload/goods03.jpg" width="50" height="50"/></td>
                    <td>这里是产品名称</td>
                    <td class="center">A15902</td>
                    <td class="center"><strong class="rmb_icon">59.00</strong></td>
                    <td class="center">
                        <p>颜色：蓝色</p>
                        <p>尺码：XXL码</p>
                    </td>
                    <td class="center"><strong>1</strong></td>
                    <td class="center"><strong class="rmb_icon">59.00</strong></td>
                    <td class="center">包</td>
                </tr>
            </table>
            <aside class="mtb" style="text-align:right;">
                <label>管理员操作：</label>
                <input type="text" class="textbox textbox_295" placeholder="管理员操作备注"/>
                <input type="button" value="打印订单" class="group_btn"/>
                <input type="button" value="确认订单" class="group_btn"/>
                <input type="button" value="付款" class="group_btn"/>
                <input type="button" value="配货" class="group_btn"/>
                <input type="button" value="发货" class="group_btn"/>
                <input type="button" value="确认收货" class="group_btn"/>
            </aside>
        </div>
        <a herf="#" onclick="javascript :history.back(-1)">返回上一页</a>
    </section>
</form>
</body>
</html>
