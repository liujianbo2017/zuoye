<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isErrorPage="true" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--设置当前页为异常处理页
	其他页面发生异常是,转跳到本页面中时,当前页面中存在异常对象:exception(内置对象)
	也就是如果直接访问此页,exception内置对象为null
	如果当前页没有设置isErrorPage="true",则当前页根本不存在exception对象
	 --%>
	 <!-- 不把程序给用户看到,使用比较温和的方式提示用户错误信息,提升用户体验 -->
	 服务器崩溃啦,请联系管理员!!!
	 <%--当某一页面发生异常跳转到异常处理页面时,使用的方式是内部转发 --%>
	 <%= exception.getMessage() %>

</body>
</html>