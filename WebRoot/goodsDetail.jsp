<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<style type="text/css">
	body{text-align:center;}
	img{width:200px; height:250px;}
	table{ margin-right: auto;
    margin-left: auto;}
    td{text-align: center;	vertical-align: middle;}
	.inputSubmit{ font-family:"Arial", "Tahoma", "微软雅黑", "雅黑"; border:0;
    vertical-align:middle; margin:8px; line-height:18px; font-size:18px; background:#6FF } 
    a{color:#6495ED;text-decoration:none; } 
	a:hover {color:#FF1493;text-decoration:underline;}
</style>
<script type="text/javascript">
	function $(id){return document.getElementById(id);}
	function add()
	{
		var num= parseInt($("num").innerText);
		if(num<=99)
		{
			num=num+1;
		}
		$("num").innerText=num;
		$("formnum").value=num;
	}
	function sub()
	{
		var num= parseInt($("num").innerText);
		if(num>0){
		num=num-1;}
		$("num").innerText=num;
		$("formnum").value=num;
	}
	function validate(){
		var num= parseInt($("num").innerText);
		if(num==0){
			alert("商品数量不能为0！");
			return false;
		}
		return true;
	}
</script>
<title>商品详情</title>
</head>
<body>
<s:if test="addShoppingStatus==1">
	<script type="text/javascript">
		alert("成功加入购物车！！！");
	</script>
</s:if>
	<s:set name="user" value="#session['user']"/>
	<a href="pageingGoods.action?page=<s:property value="page"/>">返回上一页</a><br>
	<img src="goods\\picture\\<s:property value='goods.picture'/>"></img>
	<h2><s:property value="goods.name"/></h2>
	<s>￥<s:property value="goods.marketPrice"/></s>
	<h2>会员惊喜价：￥<s:property value="goods.memberPrice"/></h2>
	
	<s:if test="#user.role==1">
		<table>
				 <tr>
				 <td><input type="button" value="-" onClick="sub();"></td>
				 <td><p name="goodsNum" id="num">0</p></td>
				 <td><input type="button" value="+" onClick="add();"></td>
				 <tr>
				 <tr>
				 <td colspan="3">
				 <form action="addShopping" method="post" onsubmit="return validate();">
				 	<input type="hidden" name="shoppingTrolley.num" value="0" id="formnum"/>
				 	<input type="hidden" name="shoppingTrolley.goodsId" value="<s:property value="goods.id"/>"/>
				 	<input type="hidden" name="shoppingTrolley.account" value="<s:property value="#user.account"/>"/>
				 	<input type="hidden" name="page" value="<s:property value="page"/>"/>
				 	<input type="submit" value="加入购物车" class="inputSubmit"/>
				 </form></td>
				 </tr>
		</table>
	</s:if>
	
	<p>${goodsContent}</p>
	

</body>
</html>