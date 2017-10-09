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
		//没有指定第三个参数,所以page域中保存了一个名字为hello的字符串
		pageContext.setAttribute("hello", "我爱Java");
		
		//不指定最后一个参数,则从page域中取得名为hello的值
		String s = (String)pageContext.getAttribute("hello");
		
		//需要使用不知道什么值代表Session域,此类一定有相对应的常量
		pageContext.setAttribute("hello", "fine 3Q", pageContext.SESSION_SCOPE);
		
		//补充,在四个域中,从小到大找,找到为止
		s = (String)pageContext.findAttribute("hello");
		
	%>
	<%= s %>
</body>
</html>