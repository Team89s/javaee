<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index.jsp</title>
<link rel="stylesheet" href="${path}/css/index.css"/>
<script type="text/javascript" src="${path}/js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="${path}/js/index.js"></script>
<script type="text/javascript" src="${path}/js/items.js"></script>
</head>
<body style="letter-spacing: -8px">
	<c:set value="${pageContext.request.contextPath}" var="path" scope="application"></c:set>
	<div class="head" style="width: 1200px;height: 200px;background-color: olive">
		<%@ include file="head.jsp" %>
	</div>
	<div class="left" style="width: 240px;height: 400px;background-color: lightblue;display:inline-block">
		<%@ include file="left.jsp" %>
	</div>
	<div class="main"  style="width: 960px;height: 400px; background-color: orange;display:inline-block;vertical-align: top">
		<%@ include file="main.jsp" %>
	</div>
	<div class="foot" style="width: 1200px;height: 100px;background-color: olive;">
		<%@ include file="foot.jsp" %>
	</div>
</body>
</html>