<%--
    page指令:
    1.import属性：导包，可以是自定的类、API中的类
    2.session属性：默认true，表示当前JSP页面会产生session这个内置对象；
    session="false"  值为false，表示当前JSP页面不会产生session这个内置对象；
    3.errorPage属性： 指定错误页面；
    4.isErrorPage属性：若值为true，则代表当前页面可以产生exception内置对象；
--%>
<%--
    JSP有九大内置对象：
        request、response、session、application、pageContext、out、page、exception、config
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="testError.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--<% Object obj = session.getAttribute("user"); %>--%>

    <%
        int x = Integer.parseInt(request.getParameter("x"));
        int y = Integer.parseInt(request.getParameter("y"));
    %>

    <%= x/y %>

</body>
</html>
