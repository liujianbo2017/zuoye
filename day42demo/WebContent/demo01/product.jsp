<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<td>t图片]</td>
							<td>ID</td>
							<td>名称</td>
							<td>价格</td>
							<td>商品描述</td>
						</tr>
					</thead>
					<tbody>
						<%--遍历Request域中名为Products的List<Product>集合 --%>
						<c:forEach var="p" items="${requestScope.products }">
							<tr>
								<td><img style="width:100px" src="${pageContext.request.contextPath }${p.img_path}"/></td>
								<td>${p.id}</td>
								<td>${p.name }</td>
								<td>${p.price }</td>
								<td>${p.description }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>