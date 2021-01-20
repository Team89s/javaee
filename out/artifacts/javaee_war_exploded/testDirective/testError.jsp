<%--
  Created by IntelliJ IDEA.
  User: cp
  Date: 2021/1/16
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>错误页面</title>
</head>
<body>
    <h1 style="color: red">
        <%= exception.getMessage() %>
    </h1>
</body>
</html>
