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
            //移除会话中属性
            //session.removeAttribute("user");

            //替换会话中属性
            session.setAttribute("user",new User());
        }
    %>

    <h1 style="color: red"><a href="user?code=logout">登出</a></h1>

    <a href=<%=response.encodeURL("testJSP/blank.jsp")%>>访问blank.jsp</a><br/>
    <a href=<%=response.encodeURL("testJSP/testFilter.jsp")%>>访问testFilter.jsp</a><br/>
    <a href=<%=response.encodeURL("fail.jsp")%>>访问fail.jsp</a>

    <%-- JSP直接使用application,作为上下文对象 --%>
    <%= application.getInitParameter("test") %>

    <%-- 显示当前访问登录的人次 --%>
    当前访问登录的人次：<%= application.getAttribute("count") %>

</body>
</html>
