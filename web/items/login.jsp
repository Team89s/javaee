<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册界面</title>
</head>
<body>
	<h1 style="color: lightcoral">${requestScope.msg}</h1>
	 <form class="loginForm">
		<table border="1px" cellspacing="0" cellpadding="10px" align="center">
			<tr>
				<td colspan="2" align="center"><h1>登陆页面</h1></td>
			</tr>
			<tr>
				<td>username</td><td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td>password</td><td><input type="password" name="pwd"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" onclick="loginServlet('${path}')" value="登陆"/>&nbsp;&nbsp;
					<input type="reset" value="重置"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>