<%@page import="cn.itcast.day38.demo06.domian.Product"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.dbutils.handlers.BeanListHandler"%>
<%@page import="cn.itcast.day38.demo06.utils.JdbcUtils"%>
<%@page import="org.apache.commons.dbutils.QueryRunner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有商品列表</title>
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
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from tb_product";
			List<Product> list = runner.query(sql, new BeanListHandler<Product>(Product.class));
			for(Product p: list){
		%>
		<tr>
			<td><img style="width:100px;" src="<%= application.getContextPath()%><%= p.getImg_path()%>"></td>
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