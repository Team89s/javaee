<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试作用域</title>
</head>
<body>
    <%
        //当前页作用域
        String name = "八戒";
        pageContext.setAttribute("name",name);
    %>

    <%-- 当前页作用域pageScope 的存储的信息 --%>
    ${pageScope.name}  <%-- 八戒 --%>

    <%-- 请求作用域requestScope 中存储的信息 --%>
    ${requestScope.name}  <%-- 唐僧 --%>

    <%-- 会话作用域sessionScope 中存储的信息 --%>
    ${sessionScope.name}  <%-- 沙和尚 --%>

    <%-- 上下文作用域applicationScope 中存储的信息 --%>
    ${applicationScope.name}  <%-- 悟空 --%>

    <%-- 若不指定作用域，只要key存在在作用域中，默认从当前作用域查找 --%>
    ${name}  <%-- 八戒 --%>

    <%-- 在任何作用域中都不存在，则没有此项值，也不会显示null --%>
    <h1>str:${str}</h1>
</body>
</html>
