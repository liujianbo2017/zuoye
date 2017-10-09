<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试两个输出流的区别</title>
</head>
<body>
		<%
			//得到响应对象中的输出流(打印流)
			PrintWriter out1 = response.getWriter();
			//out内置对象是一个JspWriter
			out.write("这是JspWriter输出的内容<br/>");
			out1.write("这是用打印流输出的内容");
		%>
</body>
</html>