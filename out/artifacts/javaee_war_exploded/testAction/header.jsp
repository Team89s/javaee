<%--
  Created by IntelliJ IDEA.
  User: cp
  Date: 2021/1/16
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试包含 - 公共的头部页面</title>
</head>
<body>
    <h1 style="color: cadetblue">欢迎访问YYY管理系统</h1>

    <%
        int x = Integer.parseInt(request.getParameter("x"));
        int y = Integer.parseInt(request.getParameter("y"));
    %>

    <h1><%= x/y %></h1>
</body>
</html>
