<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试使用EL得到请求头</title>
</head>
<body>
	
	<%--使用EL中的header内置对象取得请求头 --%>
	\${header.accept } : ${header.accept }<br/>
	
	<%--EL表达式会把属性名中的-当成减号来进行运算,所以得到0 --%>
	\${header.User-Agent } : ${header.User-Agent }<br/>
	
	<%--EL还支持另一个访问属性的方式,专门用于解决属性名中包含运算符的情况,
		此方法并不是只有H额爱的人能用,所有EL都能用
	 --%>
	 \${header['User-Agent'] } : ${header['User-Agent'] }
</body>
</html>