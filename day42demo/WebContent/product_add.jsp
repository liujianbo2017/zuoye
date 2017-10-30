<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<%@ include file="include_bootstrap.jsp" %>
	<title>信息页面</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-3"></div>
			
			<%--添加表单 --%>
			<div class="col-lg-6">

				<form action="${pageContext.request.contextPath}/productAdd.servlet" method="post" class="form-horizontal" role="form">
<%-- 					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">ID</label>
						<div class="col-sm-10">
							placeholder不是所有浏览器都支持
							<input type="text" class="form-control" id="id" name="id" placeholder="商品ID">
						</div>
					</div>
 --%>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">名称</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name" name="name" placeholder="商品名称">
						</div>
					</div>
					<div class="form-group">
						<label for="price" class="col-sm-2 control-label">价格</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="price" name="price" placeholder="商品价格">
						</div>
					</div>
					<div class="form-group">
						<label for="description" class="col-sm-2 control-label">描述</label>
						<div class="col-sm-10">
							<textarea class="form-control" id="description" name="description"></textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-success">添加</button>
							<button type="reset" class="btn btn-default">重置</button>
						</div>
					</div>
				</form>

			</div>
			<%--添加表单 结束 --%>
			
			
			<div class="col-lg-3"></div>
			
		</div>
	</div>
</body>
</html>