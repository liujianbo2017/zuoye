<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试Cookie内置对象</title>
</head>
<body>
	<%
		Cookie cookie = new Cookie("hello","Hello Cookie in EL");
		response.addCookie(cookie);	
	%>
	
	<%--得到的是Cookie的对象而不是Value --%>
	\${cookie.hello } : ${cookie.hello }<br/>
	\${cookie.hello.value } : ${cookie.hello.value }<br/>
</body>
</html>