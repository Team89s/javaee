<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试静态包含 - include指令</title>
</head>
<body>
    <%--
        静态包含：
        1.include指令
        2.file属性，包含页面
        3.发生在翻译阶段，将当前包含的页面信息翻译至本页面中
        4.header.jsp?x=10&y=5  此时不允许被发生，file只能直接指定包含的页面名称
    --%>
    <%@ include file="header.jsp?x=10&y=5"%>

    <h1 style="color: lightblue">111111</h1>
    <h1 style="color: lightblue">222222</h1>
    <h1 style="color: lightblue">333333</h1>
</body>
</html>
