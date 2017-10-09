<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试使用EL的内置对象取得请求参数</title>
</head>
<body>
	
	<%--取得名为username的请求参数的值,注意: 如果此名下有多个值,则取得第一个值--%>
	\${param.username } : %{param.username }<br />
	
	<%--一个名多个值得到的是数组引用 --%>
	\${paramVlues.username } : ${paramVlues.username }<br />
	
	<%--可以通过下标来访问数组元素 --%>
	\${paramValues.username[1] } : ${paramValues.username[1] }
</body>
</html>