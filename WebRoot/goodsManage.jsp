<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>商品管理</title>
	<style type="text/css">
	body{
   		background:url(image/registerbg.jpg)  no-repeat center center;
   		background-size:cover;
   		background-attachment:fixed;
   		background-color:#CCCCCC;
		text-align:center;
	}
	a{color:#6495ED;text-decoration:none; } 
	a:hover {color:#FF1493;text-decoration:underline;}
	</style>
</head>
	<body>
		<h2>尊敬的管理员，您可进行如下操作：</h2><br>
		<h3 align='right'><a href='index.jsp'>返回主页</a></h3>
		<hr color='#66CCFF' >
		<h2>		
			<a href='addGoods.jsp'>1.添加商品</a><br><br>
			<a href='pageingGoods.action?page=1'>2.浏览商品</a><br><br>
		</h2>
</body>
</html>