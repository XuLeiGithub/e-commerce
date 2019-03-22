<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>用户注册</title>
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
<s:if test="registerStatus==1">
	<script type="text/javascript">
		alert("注册成功！！！");
		window.document.location.href = "login.jsp";
	</script>
</s:if>
<body>
<h1 align="center">电商系统注册</h1>
<form action="register" method="post">
<table>
      <caption class="text-set">用户注册（*号标注为必填）</caption>
      <tr>
           <td class="text-set">账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号*：</td>
           <td class="text-set"><input type="text" name="user.account" class="text-set" placeholder="手机号/邮箱" /></td>
      </tr>
      <tr>
           <td class="text-set">昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称*：</td>
           <td class="text-set"><input type="text" name="user.username" class="text-set"/></td>
      </tr>
      <tr>
           <td class="text-set">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码*：</td>
           <td class="text-set"><input type="password" name="user.password" class="text-set"/></td>
      </tr> 
      <tr>
           <td class="text-set">二次确认*：</td>
           <td class="text-set"><input type="password" name="twicePassword" class="text-set"/></td>
      </tr> 
      <tr>
           <td><input type="submit" value="注册" class="text-set"/></td>
           <td><input type="reset" value="重置" class="text-set"/></td>
      </tr>
      <tr>
            <td><h2><a href="index.jsp">返回主页</a></h2></td>      		
      		<td><h2><a href="login.jsp">返回登录页面</a></h2></td>
      </tr>
</table>
</form>
</body>
</html>