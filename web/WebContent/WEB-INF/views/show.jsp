<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="stylesheet" href="/static/css/bootstrap.min.css" />
</head>
<body>
<%@ include file="header.jsp" %>
	<div class="container">

		
		<form action="/update.do" method="post" id="updateForm">

			<input type="hidden" value="${product.id}" name="id" />
			
			<h2>修改产品信息</h2>
			<label>名称：</label> 
			<input type="text" value="${product.prodname}" name="productname" /><br><br> 
			<label>价格：</label> 
			<input type="text" value="${product.prodprice}" name="productprice" /><br><br>
		    <label>数量：</label> 
		    <input type="text" value="${product.prodnum}" name="productnum" /><br><br> 
		    <label>产地：</label> 
		    <input type="text" value="${product.prodaddress}" name="productaddress" /><br><br>

			<div class="form-actions">

				<button type="button" id="bt" class="btn btn-primary">修改</button>

			</div>

		</form>

	</div>
	<script src="/static/js/jquery-1.11.3.min.js"></script>
	<script src="/static/js/jquery.validate.min.js"></script>
	<script>
	$(function(){
		
		$("#bt").click(function(){
			
			$("#updateForm").submit();	
			
		});
		
		$("#updateForm").validate({
			rules : {
				productname : { 
					required : true
				},
				productprice : { 
					required : true,
					number:true 
				},
				productnum : { 
					required : true,
					digits:true 
				},
				productaddress : { 
					required : true
				}
			},
			messages :{
				productname : { 
					required : "&nbsp;&nbsp;&nbsp;*请输入商品名称"
				},
				productprice : { 
					required : "&nbsp;&nbsp;&nbsp;*请输入商品价格",
					number:"&nbsp;&nbsp;&nbsp;*商品价格应为数字"
				},
				productnum : { 
					required : "&nbsp;&nbsp;&nbsp;*请输入商品数量",
					digits:"&nbsp;&nbsp;&nbsp;*商品数量应为数字"
				},
				productaddress : { 
					required : "&nbsp;&nbsp;&nbsp;*请输入商品产地"
				}
				
			}
		});
		
	});
	
	</script>
</body>
</html>