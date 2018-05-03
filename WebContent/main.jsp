<%@ page language="java" contentType="text/html;UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
   <table width=60% align="center">
   <tr>
   		<td align="left"><font size=2>欢迎您的光临<br><a href="javascript:logout();">退出</a></font></td>
   </tr>
   	<tr>
   		<td align="center">
   		<form name = "form2" action="" method="post">
   		<table>
   			<tr>
   				<td colspan="2">产品信息查询</td>
   				
   			</tr>
   			<tr>
   				<td >产品名称</td>
   				<td ><input type="text" name="proname" value=""/></td>
   				
   			</tr>
   			
   			<tr>
   				<td colspan="2" align="center">
   					<button type="button" onclick="searchProduct()" >查询</button>
   					<button type="button" onclick="javascript:location.href='<%%>/addProduct.jsp'">添加</button>   					
   					
   				</td>   				
   			</tr>   		
   		</table>  	
   		</form>	
   			
   		</td>
   	</tr>
   	
   	<tr>
   		<td height=50> </td>
   	</tr>
   	<tr>
   		<td> 查询结果</td>
   	</tr>
   	
   	<tr>
   	 	<td >
   	 	<form name="form1" action="" method="post">
   		<table border=1 width=100%>
   			<tr align="center">
   				<td width=10%><input type="checkbox" name="checkall" onclick="javascript:selectAll(this.checked);" /></td>
   				<td width=30%>产品名称</td>
   				<td width=30%>产品产地</td>
   				<td>产品价格</td>
   			
   			</tr>
   		
   			<tr align="center">
   				<td width=10%><input type="checkbox" name="" /></td>
   				<td width=30%></td>
   				<td width=30%></td>
   				<td></td>
   			
   			</tr>
   		</table>   		
   		</form>
   		</td>
   	
   	</tr>
   	
   	<tr>
   		<td>
   			<button type="button" onclick="javascript:del();">删除</button>
   			<button type="button" onclick="javascript:view();" >查看</button>
   		
   		</td>
   	</tr>
   	
   	<tr>
   		<td colspan="4" align="center">
   			共页    
   			<a href="javascript:first();">首页</a>   
   			<a href="javascript:forward();">上一页</a> 
   			<a href="javascript:next();">下一页</a> 
   			<a href="javascript:end();">尾页</a> 
   			跳转到<select name="select" onchange="changePage(this.value)">
   			
   			</select>
   		
   		</td>
   	</tr>
   			
   
   
   
   
   </table>
   
   
   
   </div>
</body>
</html>