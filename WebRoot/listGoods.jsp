<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>   
    <title>商品浏览</title>
    <script type="text/javascript">
    
        function validate()
        {
            var page = document.getElementsByName("page")[0].value;
                
            if(page > <s:property value="#request.pageBean.totalPage"/>)
            {
                alert("你输入的页数大于最大页数，页面将跳转到首页！");
                
                window.document.location.href = "pageingGoods.action?page=1";
                
                return false;
            }
            
            if(page<=0)
            {
				alert("页面不能为负数，页面将跳转到首页！");
                
                window.document.location.href = "pageingGoods.action?page=1";
                
                return false;
            }
            
            return true;
        }
    </script>
    <style type="text/css">
			.goodstable{width: 800px;height: 400px;}			
			.goodstd{text-align: center;	vertical-align: middle;width: 400px;height: 200px;padding:15px;}			
			.picture{ width:200px; height:250px;}
			body{text-align:center;}
			#returntd{text-align:center;}
	        #returntable{margin:0 auto;}
	        a{color:#6495ED;text-decoration:none; } 
	        a:hover {color:#FF1493;text-decoration:underline;}
		</style>

</head>
  
<body>
<s:set name="user" value="#session['user']"/>
<table align="center" border="1" class="goodstable">
	<caption><h2>商品浏览</h2></caption>
    <s:iterator value="#request.pageBean.list" id="goods" status="st">  
    	<s:if test="#st.Odd">
    	<tr>
    	</s:if>
        	<td class="goodstd"><img class="picture" src="goods\\picture\\<s:property value='#goods.picture'/>" /><br/>
			<h4>
			<s:property value="#goods.name"/>
			<br><br><s>￥<s:property value="#goods.marketPrice"/></s><br><br>
			￥<s:property value="#goods.memberPrice"/>
			</h4>
			<s:a action="goodsDetail">
				<s:param name="goods.id" value="#goods.id"></s:param>
				<s:param name="page" value="page"></s:param>
				浏览详情
			</s:a>
			<s:if test="#user.role==0">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<s:a action="inUpdate">
					<s:param name="goods.id" value="#goods.id"></s:param>
					<s:param name="goods.name" value="#goods.name"></s:param>
					<s:param name="goods.marketPrice" value="#goods.marketPrice"></s:param>
					<s:param name="goods.memberPrice" value="#goods.memberPrice"></s:param>
					<s:param name="page" value="page"></s:param>
					修改商品
				</s:a>                
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<s:a action="deleteGoods">
					<s:param name="goods.id" value="#goods.id"></s:param>
					<s:param name="page" value="page"></s:param>
					<s:param name="goods.picture" value="#goods.picture"></s:param>
					<s:param name="goods.content" value="#goods.content"></s:param>
					删除商品
				</s:a>
			</s:if>   
			</td>   
        <s:if test="#st.Even">
    	</tr>
    	</s:if>
    
    </s:iterator>
    
    </table>
    

    <h4>
           共<s:property value="#request.pageBean.totalPage"/>页 &nbsp;&nbsp;
       总计<s:property value="#request.pageBean.allRows"/>条记录<br><br>
    </h4>
        
        <s:if test="#request.pageBean.currentPage == 1">
            首页&nbsp;&nbsp;&nbsp;上一页
        </s:if>
        
        <s:else>
            <a href="pageingGoods.action?page=1">首页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="pageingGoods.action?page=<s:property value="#request.pageBean.currentPage - 1"/>">上一页</a>
        </s:else>
        	&nbsp;&nbsp;&nbsp;当前为第<s:property value="page"/>页&nbsp;&nbsp;&nbsp;
        <s:if test="#request.pageBean.currentPage != #request.pageBean.totalPage">
            <a href="pageingGoods.action?page=<s:property value="#request.pageBean.currentPage + 1"/>">下一页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="pageingGoods.action?page=<s:property value="#request.pageBean.totalPage"/>">尾页</a>
        </s:if>
        
        <s:else>
            下一页&nbsp;&nbsp;&nbsp;尾页
        </s:else><br>
        
    

        
        <form action="pageingGoods" onsubmit="return validate();">
                      跳转至
            <input type="text" size="2" name="page">页
            <input type="submit" value="跳转">
        </form>
        <s:set name="user" value="#session['user']"/>
        <table id="returntable">
        	<tr id="returntd">
        	<s:if test="#user.role==0">
        		<td><br><br><h2><a href="goodsManage.jsp">返回上一页</a></h2></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 
        	</s:if>
        		<td><br><br><h2><a href="index.jsp">返回主页</a></h2></td> 
        	</tr>
        </table>
        

    
 </body>
</html>