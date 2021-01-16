<%@ page import="com.igeek.ch02.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    <%-- 获取请求属性  Object obj = request.getAttribute("key");  --%>
    <%--<%= request.getAttribute("msg") %>--%>

    <%-- 获取请求参数 --%>
    <h1>login success , 请求参数，欢迎：<%= request.getParameter("username") %></h1>

    <%-- 在JSP页面中 ， session会话对象可以直接使用 --%>
    <%
        User user = (User)session.getAttribute("user");
        if(user!=null){
            String name = user.getName();
    %>
        <h1 style="color: cadetblue">会话属性：<%= name %></h1>
    <%
        }
    %>

    <h1 style="color: red"><a href="user?code=logout">登出</a></h1>

    <a href=<%=response.encodeURL("testJSP/blank.jsp")%>>访问blank.jsp</a>
</body>
</html>
