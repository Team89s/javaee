<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<form action="first" method="post">
    <table border="1px" cellpadding="10px" cellspacing="0">
        <tr>
            <th colspan="2">登录界面</th>
        </tr>
        <tr>
            <td>姓 名</td>
            <td><input type="text" name="username" placeholder="请输入姓名"/></td>
        </tr>
        <tr>
            <td>密 码</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td>爱 好</td>
            <td>
                <input type="checkbox" name="hobby" value="游戏" />游戏
                <input type="checkbox" name="hobby" value="编程" />编程
                <input type="checkbox" name="hobby" value="音乐" />音乐
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="登录"/>
                <input type="button" value="注册"/>
            </td>
        </tr>
    </table>
</form>

<%--
    1.地址栏直接访问，用get方式
    2.超链接直接访问，用get方式
    3.form表单默认提交，或者指定为get，则用get方式
    4.form表单默认提交，或者指定为post，则用post方式
--%>
<a href="first">访问FirstServlet</a>

</body>
</html>
