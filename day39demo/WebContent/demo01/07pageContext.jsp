<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试pageContext内置对象</title>
</head>
<body>
	<%--动态取得项目名.注意: request对象存在一个方法叫getContextPath()
		所以,此处request.contextPath不是直接访问request对象的contextPath属性
		而是在调用getContextPath方法.
		以次类推,之前饿obj.name.其实是在调用getName()方法
	 --%>
	 \${pageContext.request.contextPath } : ${pageContext.request.contextPath }
</body>
</html>