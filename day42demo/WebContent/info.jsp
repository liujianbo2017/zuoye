<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>信息页面</title>
	<%@ include file="include_bootstrap.jsp" %>
</head>
<body>
	${msg }
	<a class="btn btn-success btn-md" href="${pageContext.request.contextPath}/product.servlet">返回</a>
</body>
</html>