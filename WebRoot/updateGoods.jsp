<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>更新商品信息</title>
<style type="text/css">
	body{
   		background:url(image/registerbg.jpg)  no-repeat center center;
   		background-size:cover;
   		background-attachment:fixed;
   		background-color:#CCCCCC;
		text-align:center;
		}
	   td{text-align:center;}
	   .text-set{font-size:25px;}
	   table{margin:0 auto;}
	   a{color:#6495ED;text-decoration:none; } 
	   a:hover {color:#FF1493;text-decoration:underline;}
</style>
</head>
<body>
<s:if test="updateStatus==1">
	<script type="text/javascript">
		alert("更新成功！！！");
		window.document.location.href = "pageingGoods.action?page=<s:property value='page'/>";
	</script>
</s:if>
<form enctype="multipart/form-data" action="updateGoods" method="post">
	<table>
      <caption class="text-set">更新商品(图片和简介不填表示默认不更新)</caption>
       <tr>
           <td class="text-set">商品名：</td>
           <td class="text-set"><input type="text" name="goods.name" class="text-set" value="<s:property value="goods.name"/>"/></td>
       </tr>
       <tr>
           <td class="text-set">市场价：</td>
           <td class="text-set"><input type="text" name="goods.marketPrice" class="text-set" value="<s:property value="goods.marketPrice"/>"/></td>
       </tr>
       <tr>
           <td class="text-set">会员价：</td>
           <td class="text-set"><input type="text" name="goods.memberPrice" class="text-set" value="<s:property value="goods.memberPrice"/>"/></td>
       </tr>
       <tr>
           <td class="text-set">商品图片：</td>
           <td class="text-set"><input type="file" name="picture" class="text-set"/></td>
       </tr>
       <tr>
           <td class="text-set">商品简介：</td>
           <td class="text-set"><input type="file" name="content" class="text-set"/></td>
       </tr>
       <tr>
           <td><input type="submit" name="Submit" value="修改" class="text-set"/></td>
           <td><input type="reset" name="Reset" value="重置" class="text-set"/></td>
       </tr>
       <tr>
       		<td><br><br><h2><a href="pageingGoods.action?page=<s:property value="page"/>">返回上一页</a></h2></td>  
            <td><br><br><h2><a href="index.jsp">返回主页</a></h2></td>    		
       </tr>
       <input type="hidden" name="page" value="<s:property value="page"/>"/>
</form>
</body>
</html>