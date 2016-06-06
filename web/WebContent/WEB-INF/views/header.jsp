<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
	
		<div class="navbar-header">
		
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			
			<a class="navbar-brand" href="#">商品管理系统</a>
			
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="/home.do">主页</a></li>
				<li><a href="/save.do">添加新产品</a></li>
				<li><a href="#">产品管理</a></li>
			</ul>
			<ul class="nav navbar-nav pull-right">
				<li><a href="/logout.do" >安全退出</a></li>
			</ul>
		</div>
	</div>
</nav>