<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("ijk");
		list.add("xyz");
		pageContext.setAttribute("list", list);
	%>
	\${empty list } : ${empty list }<br/>
	
	\${list } : ${list }<br/>
	
	\${list[1] } : ${list[1] }
</body>
</html>