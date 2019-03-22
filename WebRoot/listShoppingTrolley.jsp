<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<title>查看购物车</title>
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
<s:if test="buyStatus==1">
	<script type="text/javascript">
		alert("支付成功！！！");
	</script>
</s:if>
<s:set name="user" value="#session['user']"/>
<table>
	<caption><h2><s:property value="#user.username"/>的购物车</h2></caption>
	<tr>
        <th>图片</th>
        <th>商品名</th>
        <th>单价</th>
        <th>数量</th>
        <th>总计</th>
        <th colspan="2">操作</th>
    </tr>
    <s:iterator value="#request.shoppingList" id="shoppingTrolley" status="status">
    <tr>
    	<td><img src="goods\\picture\\<s:property value='%{#request.goodsList[#status.index].picture}'/>"/></td>
    	<td><s:property value='%{#request.goodsList[#status.index].name}'/></td>
    	<td>￥<s:property value='%{#request.goodsList[#status.index].memberPrice}'/></td>
    	<td><s:property value="#shoppingTrolley.num"/></td>
    	<td>￥<s:property value="%{#request.moneyList[#status.index]}"/></td>
    	<td>
    	<s:a action="addOrderForm">
    		<s:param name="orderForm.goodsId" value="#shoppingTrolley.goodsId"></s:param>
    		<s:param name="orderForm.account" value="#shoppingTrolley.account"></s:param>
    		<s:param name="orderForm.num" value="#shoppingTrolley.num"></s:param>
    		<s:param name="orderForm.totalMoney" value="%{#request.moneyList[#status.index]}"></s:param>
    		立即支付
    	</s:a>
    	</td>
		<td>
		<s:a action="deleteShopping">
			<s:param name="shoppingTrolley.id" value="#shoppingTrolley.id"></s:param>
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