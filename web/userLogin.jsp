<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录界面</title>
</head>
<body>
<%
    String msg = (String)request.getAttribute("msg");
    if(msg!=null){
%>
        <h1 style="color:red"><%= msg %></h1>
<%
    }
%>
<form id="loginForm" action="user" method="post">
    <table border="1px" cellpadding="10px" cellspacing="0">
        <tr>
            <th colspan="2">用户登录界面</th>
        </tr>
        <tr>
            <td>姓 名</td>
            <td><input type="text" name="username" placeholder="请输入姓名" id="username" required="required" /></td>
        </tr>
        <tr>
            <td>密 码</td>
            <td><input type="password" name="password" id="password" required="required" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="登录"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
