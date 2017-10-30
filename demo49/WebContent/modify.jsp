<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息页面</title>
<%@ include file="include_bootstrap.jsp"%>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-lg-3"></div>
			
			<%--添加表单 --%>
			<div class="col-lg-6">

				<form action="${pageContext.request.contextPath}/productModify.servlet" method="post" class="form-horizontal" role="form">
					<%--因为是修改，所以ID必须要回填，也必须要提交，但不需要给用户看。所以使用hidden --%>
					<input type="hidden" name="id" value="${product.id }" />
					
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">名称</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name" name="name" value="${product.name }" placeholder="商品名称">
						</div>
					</div>
					<div class="form-group">
						<label for="price" class="col-sm-2 control-label">价格</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="price" name="price" value="${product.price }" placeholder="商品价格">
						</div>
					</div>
					<div class="form-group">
						<label for="description" class="col-sm-2 control-label">描述</label>
						<div class="col-sm-10">
							<%--textarea起始标签和结束标签中的所有都是内容 --%>
							<textarea class="form-control" id="description" name="description">${product.description }</textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-success">修改</button>
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