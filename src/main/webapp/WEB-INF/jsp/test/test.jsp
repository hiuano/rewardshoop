<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Sven
  Date: 2018/3/1
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试页</title>
</head>
<body>
<c:if test="${errors !=null&&errors.size()>0}">
    <c:forEach items="${errors}" var="err">
        ${err.defaultMessage}<br/>
    </c:forEach>
</c:if>
</body>
</html>
