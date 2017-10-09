<%@page import="cn.itcast.day38.demo07.domain.Product"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.dbutils.handlers.BeanListHandler"%>
<%@page import="cn.itcast.day38.demo07.utils.JdbcUtils"%>
<%@page import="org.apache.commons.dbutils.QueryRunner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center" width="800" border="1">
		<tr>
			<th>图片</th>
			<th>ID</th>
			<th>名称</th>
			<th>价格</th>
			<th>描述</th>
		</tr>
		<%
			//从Request域中取得所有商品信息的集合
			List<Product> list = (List<Product>)request.getAttribute("products");
			for(Product p: list){
		%>
		<tr>
			<td><img style="width: 100px" src="<%= application.getContextPath()%><%= p.getImg_path()%>"/></td>
			<td><%= p.getId() %></td>
			<td><%= p.getName() %></td>
			<td><%= p.getPrice() %></td>
			<td><%= p.getDescription() %></td>
		</tr>
		<% 
			}
		%>
	</table>
</body>
</html>