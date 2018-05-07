<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function dosubmit(){
	var th = document.form1;
	th.action="<%= path%>/servlet/ProductAction?action_flag=add";
	th.submit();

}

</script>
</head>
  <body>
	<div align="center">
	
		<table width=70% style="margin:auto;">
			<tr><td align="center" height=150 valign="bottom">产品信息添加</td></tr>
			<tr>
				<td>
					<form id="form1" name="form1" action="" method="post" enctype="multipart/form-data">
					<table border=1 style="margin:auto">
						<tr >
							<td>产品名称</td>
							<td><input type="text" name="proname" id="proname"/></td>
							<td>产品价格</td>
							<td><input type="text" name="proprice" id="proprice"/></td>
						</tr>
						<tr>
							<td>产品产地</td>
							<td colspan="3"><input type="text" name="proaddress" id="proaddress"/></td>
						</tr>
						<tr>
							<td>产品图片</td>
							<td colspan="3"><input type="file" name="proimage" id="proimage"  size=35/></td>
						</tr>
					
					</table> 
					</form>   				
				
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<button type="button" onclick="javascript:dosubmit();">确定</button>
					<button type="button" onclick="javascript:location.href='main.jsp'">返回</button>
				
				</td>
			</tr>
			
		
		</table>
		
	</div>
  </body>
</html>