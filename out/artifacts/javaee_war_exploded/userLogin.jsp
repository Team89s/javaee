<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录界面</title>
</head>
<body>
    <%
        //从请求中获取所有的Cookie，从而获取免登录的信息
        String username = null;
        String password = null;

        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if(cookie!=null){
                    if(cookie.getName().equals("usernameCookie")){
                        //解码
                        username = URLDecoder.decode(cookie.getValue(),"UTF-8");
                    }
                    if(cookie.getName().equals("passwordCookie")){
                        password = cookie.getValue();
                    }
                }
            }
        }

        if (username!=null && password!=null) {
            request.getRequestDispatcher("user?username="+username+"&password="+password).forward(request,response);
        }
    %>


    <%
        String msg = (String)request.getAttribute("msg");
        if(msg!=null){
    %>
            <h1 style="color:red"><%= msg %></h1>
    <%
        }
    %>
    <form id="loginForm" action="user?code=login" method="post">
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
                    <select name="timeLength">
                        <option value="0">一直登录</option>
                        <option value="7">7天内免登录</option>
                        <option value="15">15天内免登录</option>
                    </select>
                </td>
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
