<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--设置当前页面的异常处理页是哪个页面 --%>
<%@ page errorPage="err.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h2>这是页面的内容</h2>
		<% 
			//模拟页面抛出异常
			int a = 1/0; 
		%>
</body>
</html>