<%@page import="java.util.Date"%>
<%@page import="cn.itcast.day41.demo04.User"%>
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
		User user = new User();
		user.setId("user001");
		user.setName("张三");
		user.setGender(true);
		user.setBirthday( new Date() );
		
		//触发绑定事件
		session.setAttribute("User", user);
		
		//触发解绑事件
		session.removeAttribute("User");
	%>
</body>
</html>