<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>修改商品信息</title>
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.js"></script>
</head>
<body>
	<div style="padding: 0 100px;margin-top: 10px;width: 500px;height: 100%">
		<h2 class="form-group">添加商品</h2>
		<%-- enctype="multipart/form-data"  当前表单数据将以二进制数据传递 --%>
		<form id="addForm" action="" method="post" enctype="multipart/form-data">
			<div class="form-group" hidden="hidden">
				<label for="id">商品id</label>
				<input type="text" class="form-control" id="id" placeholder="id" name="id" value="${items.id}">
			</div>
			<div class="form-group">
				<label for="name">商品名称</label>
				<input type="text" class="form-control" id="name" placeholder="name" name="name" required="required"
					onchange="validateName('${path}')" value="${items.name}">
				<span class="nameMsg"></span>
			</div>
			<div class="form-group">
				<label for="detail">商品描述</label>
				<input type="text" class="form-control" id="detail" placeholder="desc" name="detail" value="${items.detail}">
			</div>
			<div class="form-group">
				<label for="price">商品价格</label>
				<input type="text" class="form-control" id="price" placeholder="price" name="price" required="required" value="${items.price}">
			</div>
			<div class="form-group">
				<label for="pic">商品图片</label>
				<img id="pic" name="pic" width="100" height="100" src="${items.pic}" />
				<input type="file" class="form-control" id="file" name="file"
					   onchange="showPreview(this)">
			</div>
			<div class="form-group">
				<label for="createtime">生产日期</label>
				<input type="text" class="form-control Wdate" id="createtime" placeholder="createtime" name="createtime"
					   value="${items.createtime}"
					   onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
			</div>
			<button type="button" class="btn btn-success" onclick="addServlet('${path}')">提交</button>
		</form>
	</div>
</body>
<script type="text/javascript">
	//将文件流以url形式读取，实现图片实时显示：
	function showPreview(source){
		var file = source.files[0];
		if(window.FileReader){
			var fr = new FileReader();
			fr.onloadend = function(e){
				//document.getElementById("pic").src=e.target.result;
				$("#pic").attr("src",e.target.result);
				$("#pic").css({"width":"64px","height":"auto"});
			}
			fr.readAsDataURL(file);
		}
	}
</script>
</html>