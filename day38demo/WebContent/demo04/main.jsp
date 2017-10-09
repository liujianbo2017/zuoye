<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
</head>
<body>
		<h3>这是主页面内容1</h3>
		<%--使用动态页面包含另一页面 --%>
		<jsp:include page="aaa.jsp"></jsp:include>
		<h3>这是主页面内容2</h3>
</body>
</html>