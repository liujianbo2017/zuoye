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
			//向域中添加属性
			request.setAttribute("hello", "楚风");
			//触发替换事件
			request.setAttribute("hello", "hello request attribute");
			//触发删除事件
			request.removeAttribute("hello");
		%>
</body>
</html>