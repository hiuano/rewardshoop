<%--
  Created by IntelliJ IDEA.
  User: Sven
  Date: 2018/2/28
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>积分商城</title>
    <meta name="keywords" content="星光珠宝"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css"/>
    <style>
        body {
            height: 100%;
            background: #16a085;
            overflow: hidden;
        }

        canvas {
            z-index: -1;
            position: absolute;
        }
    </style>
    <script src="<%=path%>/js/jquery.js"></script>
    <script src="<%=path%>/js/verificationNumbers.js"></script>
    <script src="<%=path%>/js/Particleground.js"></script>
    <script>
        $(document).ready(function () {
            //粒子背景特效
            $('body').particleground({
                dotColor: '#5cbdaa',
                lineColor: '#5cbdaa'
            });
            //验证码
            createCode();
            //测试提交，对接程序删除即可
            // $(".submit_btn").click(function () {
            //     if (validate()) {
            //         document.getElementById("login").submit();
            //     } else {
            //         alert("验证码错误");
            //     }
            // })
        });
    </script>

</head>
<body>
<form action="<%=path%>/loginAdmin/login" method="post" id="login" name="login">
    <dl class="admin_login">

        <dt>
            <strong>星光珠宝积分商城管理系统</strong>
            <em>Starshine Rewardshoop Management System</em>
        </dt>

        <dd class="user_icon">
            <input type="text" name="adminName" placeholder="账号" class="login_txtbx"/>
        </dd>
        <dd class="pwd_icon">
            <input type="password" name="password" placeholder="密码" class="login_txtbx"/>
        </dd>
        <%--验证码,处理不好验证,kill--%>
        <%--<dd class="val_icon">--%>
        <%--<div class="checkcode">--%>
        <%--<input type="text" id="J_codetext" placeholder="验证码" maxlength="4" class="login_txtbx">--%>
        <%--<canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>--%>
        <%--</div>--%>

        <%--<input type="button" value="验证码核验" class="ver_btn" onClick="validate();">--%>
        <%--</dd>--%>
        <dd>
            <p style="color: red">${errMsg}</p>
        </dd>
        <dd>
            <input type="submit" value="立即登录" class="submit_btn"/>
        </dd>

    </dl>
</form>
</body>
</html>

