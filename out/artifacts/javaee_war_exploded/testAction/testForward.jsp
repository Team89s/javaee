
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试标准动作 - forward</title>
</head>
<body>
    <%-- forward动作：在JSP页面中进行请求转发。 --%>
    <jsp:forward page="header.jsp">
        <%-- 传递了请求参数 --%>
        <jsp:param name="x" value="10"/>
        <jsp:param name="y" value="5"/>
    </jsp:forward>
</body>
</html>
