<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>分页显示</title>
	<%@ include file="../include_bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<%--查询条件表单 --%>
		<div class="row">
			<div class="col-lg-12 text-center">
				<form action="${pageContext.request.contextPath }/productListByCondition.servlet" method="post" class="form-horizontal" role="form">
					分类：
					<select class="form-control" name="category_id">
						<option value="">---请选择---</option>
						
						<%--遍历ServletContext域中所有分类集合 --%>
						<c:forEach var="c" items="${allCategorys }">
							<option ${c.id==condition.category_id?'selected':'' } value="${c.id }">${c.name }</option>
						</c:forEach>

					</select>
					名称：
					<input type="text" class="form-control" placeholder="商品名称" name="name" value="${condition.name }">
					
					<input type="submit"  value="查询" />
				</form>
			</div>
		</div>
		<%--查询条件表单 结束--%>
	
		<%--显示商品的表单部分 --%>
		<div class="row">
			<div class="col-lg-12">
				<table class="table table-bordered table-striped table-hover">
					<thead>
						<tr>
							<th>图片</th>
							<th>ID</th>
							<th>名称</th>
							<th>价格</th>
							<th>描述</th>
						</tr>
					</thead>
					<tbody>

						<%--遍历的是PageBean对象的data属性（List<Product>） --%>
						<c:forEach var="p" items="${products }">
						<tr>
							<td><img style="width:80px;" src="${pageContext.request.contextPath}${p.img_path}"/></td>
							<td>${p.id }</td>
							<td>${p.name }</td>
							<td>${p.price }</td>
							<td>${p.description }</td>
						</tr>
						</c:forEach>
						
					</tbody>
				</table>
			</div>
		</div>
		<%--显示商品的表单部分 结束 --%>
		
		
	</div>

</body>
</html>