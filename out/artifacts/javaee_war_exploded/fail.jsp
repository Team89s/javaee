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
    <title>登录失败</title>
</head>
<body>
    <%= request.getAttribute("msg") %>
    <h1>login fail</h1>
</body>
</html>
