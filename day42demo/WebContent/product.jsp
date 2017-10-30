<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<%@ include file="include_bootstrap.jsp" %>
	<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<%--显示商品列表 --%>
		<div class="row">
			<div class="col-lg-12">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>图片</th>
							<th>ID</th>
							<th>名称</th>
							<th>价格</th>
							<th>描述</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<%--遍历Request域中名为Products的List<Product>集合 --%>
						<c:forEach var="p" items="${products }">
							<tr>
								<td><img style="width:100px" src="${pageContext.request.contextPath }${p.img_path}"/></td>
								<td>${p.id}</td>
								<td>${p.name }</td>
								<td>${p.price }</td>
								<td>${p.description }</td>
								<td>
									<%--当点击删除时，发送请求到ProductDeleteServlet，并提交当前商品ID --%>
									<a href="${pageContext.request.contextPath }/productDelete.servlet?id=${p.id}" class="btn btn-danger btn-xs">删除</a>
									<a href="${pageContext.request.contextPath }/productGoModifyUI.servlet?id=${p.id}">修改</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<%--显示商品列表结束 --%>
		
		<%--添加按钮 --%>
		<div class="row">
			<div class="col-lg-12 text-center">
			<%--当点击“添加”按钮时，把请求发送的一个专门负责转跳到添加页面的Servlet中（主要是为了让项目的结构符合MVC） --%>
				<a class="btn btn-info btn-lg" href="${pageContext.request.contextPath }/productGoAddUI.servlet">添加</a>
			</div>
		</div>
	</div>
</body>
</html>