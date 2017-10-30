<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>分页显示</title>
	<%@ include file="../include_bootstrap.jsp" %>
</head>
<body>
	<div class="container">
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
						<c:forEach var="p" items="${products.data }">
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
		
		<%--分页条 --%>
		<div class="row">
			<div class="col-lg-12 text-center">
				<ul class="pagination">
					<%--当前页号等于1时，不能使用上一页，上一页的按钮设置为禁用，这个禁只是一个鼠标的效果，并不能真的禁用
						作业：
							1、如果当前是第一页，那么点上一页时不变、如果当前是最后一页，点下一页不变
							2、如果当前是第一页，那么点上一页时到最后一页。如果当前是最后一页，点下一页到第一页。
					 --%>
					<li ${products.pageNum==1?'class="disabled"':'' }><a href="${pageContext.request.contextPath}/productListByPage.servlet?pageNum=${products.pageNum-1==0?products.pageCount:products.pageNum-1}&pageSize=5">&laquo;</a></li>

					<%--生成分页条的计数型循环，生成从1开始到总页数结束的N个超链接，代表所有页，点几就转跳到第几页 --%>
					<c:forEach var="i" begin="1" end="${products.pageCount }">
						<%--判断当前页号是否是i --%>
						<li ${products.pageNum==i?'class="active"':'' }><a href="${pageContext.request.contextPath}/productListByPage.servlet?pageNum=${i}&pageSize=5">${i }</a></li>
					</c:forEach>
					
					<%--当前页号等于总页数（当前是最后一页），则下一页的按钮设置为禁用 --%>
					<li ${products.pageNum==products.pageCount?'class="disabled"':'' }><a href="${pageContext.request.contextPath}/productListByPage.servlet?pageNum=${products.pageNum==products.pageCount?products.pageNum-1:products.pageNum+1}&pageSize=5">&raquo;</a></li>
				</ul>
			</div>
		</div>
		<%--分页条 结束--%>
		
	</div>

</body>
</html>