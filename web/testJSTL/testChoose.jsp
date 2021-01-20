<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>测试c:choose / c:when / c:otherwise 标签</title>
</head>
<body>

    <%-- c:set 设置值 --%>
    <c:set value="10" scope="request" var="i"></c:set>

    <%-- c:choose 类比Java中的if..else if...else --%>
    <c:choose>

        <c:when test="${i<5}">
            i的值<5
        </c:when>

        <c:when test="${i<10}">
            i的值<10
        </c:when>

        <c:otherwise>
            i的值>=10
        </c:otherwise>

    </c:choose>

</body>
</html>
