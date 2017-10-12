<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align:right">
		<c:if test="${empty sessionScope.current_user }">
			<a href="login.jsp">登录</a>
			<a href="#">注册</a>
		</c:if>
		<c:if test="${not empty sessionScope.current_user }">
			${sessionScope.current_user.username }
		</c:if>
	</div>
	<h2>这是首页的内容</h2>
</body>
</html>