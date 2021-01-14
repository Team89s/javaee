<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<form id="loginForm" action="login" method="post">
    <table border="1px" cellpadding="10px" cellspacing="0">
        <tr>
            <th colspan="2">登录界面</th>
        </tr>
        <tr>
            <td>姓 名</td>
            <td><input type="text" name="username" placeholder="请输入姓名" id="username" /></td>
        </tr>
        <tr>
            <td>密 码</td>
            <td><input type="password" name="password" id="password"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="登录1"/>
                <input type="button" value="登录2"/>
            </td>
        </tr>
    </table>
</form>

<a href="login?username=李思思&password=123">访问LoginServlet</a>

</body>
<script src="js/jquery-3.1.1.js"></script>
<script>
    
    $(":button").click(function () {
        var username = $("#username").val();
        console.log(username)
        if(username!=null && username!="") {
            console.log(111)
            $("#loginForm").submit();
        }
    });
    
</script>
</html>
