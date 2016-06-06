<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="stylesheet" href="/static/css/bootstrap.min.css" />
<style>
body {
	padding-top: 55px;
}
tr:hover {
    background-color: #d3ff99;
    cursor: pointer;
}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<a href="/save.do" class="btn btn-success">添加新产品</a>

		<table class="table">

			<thead>
				<tr>
					<th>序号</th>
					<th>商品名称</th>
					<th>价格</th>
					<th>数量</th>
					<th>产地</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="prod" items="${productList}" varStatus="vs">

					<tr>
						<td>${vs.count}</td>
						<td>${prod.prodname}</td>
						<td>${prod.prodprice}</td>
						<td>${prod.prodnum}</td>
						<td>${prod.prodaddress}</td>

						<td>
							<a href="javascript:;" data-id="${prod.id}" class="delLink">删除</a> 
							<a href="/edit.do?id=${prod.id}">修改</a>
						</td>

					</tr>
				</c:forEach>
				
			</tbody>
		</table>

	</div>
	<script src="/static/js/jquery-1.11.3.min.js"></script>

	<script>
		$(function() {

			$(".delLink").click(function() {

				if (confirm("确定要删除吗？")) {
					var id = $(this).attr("data-id");
					window.location.href = "/delete.do?id=" + id;
				}

			});

		});
	</script>

</body>
</html>