<%--
  Created by IntelliJ IDEA.
  User: cp
  Date: 2021/1/15
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    <%-- 获取请求属性  Object obj = request.getAttribute("key");  --%>
    <%--<%= request.getAttribute("msg") %>--%>

    <%-- 获取请求参数 --%>
    <h1>login success , 欢迎：<%= request.getParameter("username") %></h1>
</body>
</html>
