<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
      <title>用户登录</title>
      <style type="text/css">
	   body{
   		background:url(image/bgimage.jpg)  no-repeat center center;
   		background-size:cover;
   		background-attachment:fixed;
   		background-color:#CCCCCC;
		text-align:center;
		}
	   td{text-align:center;}
	   .text-set{font-size:25px;}
	   table{margin:0 auto;}
	   a{color:#FF1493;text-decoration:none; } 
	   a:hover {color:#CC3300;text-decoration:underline;}
      </style>
</head>
<body>
<h1 align="center">电商系统登录</h1>
<s:form action="login" method="post">
<table>
      <caption class="text-set">用户登录</caption>
      <tr>
           <td class="text-set">账 号：</td>
           <td class="text-set"><input type="text" name="user.account" class="text-set" placeholder="手机号/邮箱"/></td>
      </tr>
      <tr>
           <td class="text-set">密 码：</td>
           <td class="text-set"><input type="password" name="user.password" class="text-set"/></td>
      </tr> 
      <tr>
           <td><input type="submit" name="Submit" value="登录" class="text-set"/></td>
           <td><input type="reset" name="Reset" value="重置" class="text-set"/></td>
      </tr>
</table>
</s:form>
<br><br><br><br><br><br><br><br><br><br>
<h2><a href="register.jsp">未有账号？点击这里</a></h2>
</body>
</html>