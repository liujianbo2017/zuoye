<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试EL中的域内置对象</title>
</head>
<body>
	<%
		String a = "hello EL";
		request.setAttribute("hello", a);
		
		application.setAttribute("hello", "how r u");
	%>
	
	<%--早Request域中查找名为hello的属性 
		如果此值不存在,则不会显示null,而是返回空字符串(什么都没哟)
	--%>
	${ requestScope.hello }<br />
	
	${ applicationScope.hello }<br />
	
	<%--如果不指定域,则在四个域中从小到大查找,找到即停止 --%>
	${ hello }<br />
	
</body>
</html>