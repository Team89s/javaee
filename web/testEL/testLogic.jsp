<%@ page import="com.igeek.ch02.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试运算符</title>
</head>
<body>
    <%
        int x = 10;
        int y = 5;
        boolean flag1 = true;
        boolean flag2 = false;
        pageContext.setAttribute("x",x);
        pageContext.setAttribute("y",y);
        pageContext.setAttribute("flag1",flag1);
        pageContext.setAttribute("flag2",flag2);
    %>

    <h1 style="color: lightseagreen">x + y = ${x+y}</h1>
    <h1 style="color: lightcoral">flag1 && flag2 = ${flag1 && flag2}</h1>
    <h1 style="color: lightblue">x > y = ${x gt y}</h1>

    <%
        User user = new User();
        user.setName("张三");
        pageContext.setAttribute("user",user);
    %>
    ${empty user}  <%--  当前为空则是true，不为空则是false   --%>

    ${user!=null ? user.name : ""}
    ${user ne null ? user.name : ""}

</body>
</html>
