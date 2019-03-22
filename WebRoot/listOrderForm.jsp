<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>我的订单</title>
<style type="text/css">
	img{width:70px; height:80px;}
	table{width: 800px;height: 400px;margin:0 auto;}			
	td{text-align: center;	vertical-align: middle;}
	th,td{ padding:5px;}
	body{text-align:center;}
	table,table tr th, table tr td { border:1px solid #0094ff; }
	a{color:#6495ED;text-decoration:none; } 
	a:hover {color:#FF1493;text-decoration:underline;}
</style>
</head>
<body>
<s:set name="user" value="#session['user']"/>
<table>
	<caption><h2><s:property value="#user.username"/>的订单</h2></caption>
	<tr>
        <th>图片</th>
        <th>商品名</th>
        <th>单价</th>
        <th>数量</th>
        <th>总计</th>
        <th>订单提交时间</th>
        <th colspan="2">操作</th>
    </tr>
    <s:iterator value="#request.orderList" id="orderForm" status="status">
    	<tr>
			<td><img src="goods\\picture\\<s:property value='%{#request.goodsList[#status.index].picture}'/>"/></td>
			<td><s:property value='%{#request.goodsList[#status.index].name}'/></td>
			<td>￥<s:property value='%{#request.singleMoneyList[#status.index]}'/></td>
			<td><s:property value="#orderForm.num"/></td>
			<td>￥<s:property value="#orderForm.totalMoney"/></td>
			<td>20<s:property value='#orderForm.orderTime'/></td>
			<td>
			<s:a action="deleteOrderForm">
				<s:param name="orderForm.id" value="#orderForm.id"></s:param>
				删除
			</s:a>
			</td>
		</tr>
    </s:iterator>
</table>
<br><br><br><br>
<h2><a href="index.jsp">返回主页</a></h2>
</body>
</html>