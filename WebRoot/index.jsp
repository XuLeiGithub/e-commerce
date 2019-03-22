<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<style type="text/css">	
	body{
   	background:url(image/index_bg.jpg)  no-repeat center center;
   	background-size:cover;
   	background-attachment:fixed;
   	background-color:#CCCCCC;
	text-align:center;
	}
	a{color:#6495ED;text-decoration:none; } 
	a:hover {color:#FF1493;text-decoration:underline;}
	h3{text-align:right;}
</style>
</head>
<body>
	<s:set name="user" value="#session['user']"/>
	<s:if test="#user==null">
		<br>
		<h1><a href='login.jsp'>亲，请登录</a></h1>
	</s:if>
	<s:else>
		<h1><s:property value="#user.username"/>
		(<s:if test="#user.role==0">管理员</s:if><s:else>会员</s:else>)，欢迎登录本系统!!!!</h1>
		<h2>尊敬的<s:property value="#roleName"/>您可进行如下操作：</h2>
		<h3><s:a href='logout'>注销登录</s:a></h3>
		<hr color="#66CCFF">
		<s:if test="#user.role==1">
			<h2>		
				<a href='pageingGoods.action?page=1'>1.浏览商品</a><br><br>
				<s:a href='listShopping'>2.购物车</s:a><br><br>
				<a href='listOrderForm'>3.我的订单</a><br><br>
			</h2>
		</s:if>
		<s:if test="#user.role==0">
			<h2>		
				<a href='goodsManage.jsp'>1.商品管理</a><br><br>
			</h2>
		</s:if>	
	</s:else>
	<s:debug/>
</body>
</html>