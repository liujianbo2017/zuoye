<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试EL访问Map集合中的数据</title>
</head>
<body>
	<%
		Map<String,String> map = new HashMap<String,String>();
		map.put("user001","楚风");
		map.put("user002","妖妖公主");
		map.put("user003","黄牛");
		pageContext.setAttribute("map", map);
	%>
	\${map } : ${map }<br/>
	
	<%--通过Map中的key来取得其中的值 --%>
	\${map.user001 } : ${map.user001 }
</body>
</html>