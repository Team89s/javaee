<%@ page import="java.util.*" %>
<%@ page import="com.igeek.ch02.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>解析复杂数据</title>
</head>
<body>

    <%-- 1.测试数组 --%>
    <%
        int[] arr = {1,2,3,4,5};
        pageContext.setAttribute("arr",arr);
    %>
    <%-- EL表达式操作时，可以直接使用  数组名[下标] --%>
    <h1 style="color:cadetblue">通过下标直接操作：${arr[3]}</h1>


    <%-- 2.测试集合 --%>
    <%
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        pageContext.setAttribute("list",list);
    %>
    <h1 style="color:lightcoral">通过下标直接操作：${list[1]}</h1>

    <%
        Map<String,Integer> map = new TreeMap<>();
        map.put("abd",10);
        map.put("abc",20);
        map.put("abb",30);
        pageContext.setAttribute("map",map);
    %>
    <h1 style="color:lightsalmon">通过key获得value：${map.abc}</h1>
    <h1 style="color:lightsalmon">通过key获得value：${map["abb"]}</h1>

    <%-- 自定义的对象 --%>
    <%
        User user = new User();
        user.setName("小红花");
        user.setPwd("123");
        pageContext.setAttribute("user",user);
    %>
    <h1 style="color:lightseagreen">${user.name}</h1>
    <h1 style="color:lightseagreen">${user["pwd"]}</h1>
    <h1 style="color:lightseagreen">${user}</h1>

</body>
</html>
