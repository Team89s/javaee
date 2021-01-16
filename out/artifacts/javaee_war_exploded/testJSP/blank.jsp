<%@ page import="com.igeek.ch02.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%= request.getRemoteAddr() %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
    <%--  登录访问控制 --%>
    <%
        User user = (User)session.getAttribute("user");
        if(user==null) {
            request.setAttribute("msg","当前资源必须登录后访问");
            request.getRequestDispatcher("../userLogin.jsp").forward(request,response);
        }
    %>

    <%
        for(int i=0;i<10;i++) {
    %>
            <h1 style="color:red"><%= i %></h1>
    <%
        }
    %>
    </>
</body>
</html>
