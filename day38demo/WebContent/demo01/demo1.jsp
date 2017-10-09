<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>大家好,这是我的JSP动态页面</h1>
	<% 
	//由第一种脚步括起来的java代码都是_jspService方法中的代码,所以定义的变量是局部变量
	int a = 10;
	System.out.println(a);
	%>
	<%= a %>,<br/>
	<!-- 计算表达式的值,并体替换到当前位置,计算是在服务端执行的,执行的最终静态结果法规给浏览器.
		 说明:JSP的运行是和Servlet一样是服务端的
		 为什么WEB服务器在安装的时候需要JDK(因为需要翻译后进行编译,JRE不能满足需求)
	 -->
	<font size="<%= a-3 %>">这是测试文本</font>
	<!-- 用第三种脚本定义的是类的成员.   基本不用 -->
	<%! int a = 20; %>
</body>
</html>