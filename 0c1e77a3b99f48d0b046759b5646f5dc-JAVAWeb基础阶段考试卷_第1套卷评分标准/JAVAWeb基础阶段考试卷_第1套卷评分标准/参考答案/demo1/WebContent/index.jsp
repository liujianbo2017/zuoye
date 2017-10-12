<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<c:if test="${empty user }">
			<h2>
				<a href="${pageContext.request.contextPath }/login.jsp">登录</a>
			</h2>
		</c:if>
		<c:if test="${not empty user }">
			<h2>${user.username }:欢迎回来!</h2>
		</c:if>
		<h2>
			<a href="${pageContext.request.contextPath }/linkman_save.jsp">新增联系人</a>
		</h2>
		
	</center>
</body>
</html>