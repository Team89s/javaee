<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%= request.getRemoteAddr() %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
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
