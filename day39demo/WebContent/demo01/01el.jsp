<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		//定义的局部变量EL表达式是不能访问的
		int b = 1;
		//保存域中才可以被EL访问
		pageContext.setAttribute("a", b);
	%>
	
	<%--EL中的变量名,是域中的名字,和局部变量名无关 --%>
	${ 1+2+a }
</body>
</html>