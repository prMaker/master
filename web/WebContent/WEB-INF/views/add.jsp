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

		<form action="/save.do" method="post" id="newFrom">

			<h2>添加新产品</h2>
			
			<label>名称：</label> 
			<input type="text" placeholder="输入产品名称" name="productname" /><br><br> 
			<label>价格：</label>
			<input type="text" placeholder="输入产品价格" name="productprice" /><br><br> 
			<label>数量：</label> 
			<input type="text" placeholder="输入产品数量" name="productnum" /><br><br> 
			<label>产地：</label> 
			<input type="text" placeholder="输入产地" name="productaddress" /><br><br>

			<div class="form-actions">

				<button type="button" id="bt" class="btn btn-primary">添加</button>

			</div>

		</form>

	</div>
	<script src="/static/js/jquery-1.11.3.min.js"></script>
	<script src="/static/js/jquery.validate.min.js"></script>
	<script>
	$(function(){
		
		$("#bt").click(function(){
			
			$("#newFrom").submit();	
			
		});
		
		$("#newFrom").validate({
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