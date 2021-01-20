<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>测试c:forEach标签</title>
</head>
<body>

    <%--
        方式一：循环,控制循环的次数
        1.begin属性  起始值
        2.end属性    终止值
        3.step属性   步长
        4.varStatus属性 记录当前迭代的状态
    --%>
    <c:forEach begin="2" end="12" step="2" varStatus="sta">
        当前正在迭代的项：${sta.current}
        当前迭代到第几次：${sta.count}
        当前是否是第一项：${sta.first}
        当前是否是第二项：${sta.last}
        当前迭代的索引号：${sta.index}
        <br/><hr>
    </c:forEach>


    <%-- 方式二：迭代数组、集合 --%>
    <%
        int[] arr = {10,20,30,40,50};
        pageContext.setAttribute("as",arr);

        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("abb");
        list.add("abd");
        pageContext.setAttribute("ls",list);

        Map<String,String> map = new TreeMap<>();
        map.put("k1","v1");
        map.put("k2","v2");
        map.put("k3","v3");
        pageContext.setAttribute("map",map);
    %>

    <c:forEach items="${as}" var="a">
        ${a}<br/>
    </c:forEach>

    <br/><hr>

    <c:forEach items="${ls}" var="l">
        ${l}<br/>
    </c:forEach>

    <br/><hr>

    <c:forEach items="${map}" var="entry">
        ${entry.key} = ${entry.value}<br/>
    </c:forEach>

</body>
</html>
