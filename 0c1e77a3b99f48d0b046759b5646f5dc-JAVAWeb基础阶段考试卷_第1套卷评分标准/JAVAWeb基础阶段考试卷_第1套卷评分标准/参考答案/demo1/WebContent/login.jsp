<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form method="post" action="${pageContext.request.contextPath }/login">
			<table width="40%" height="60%"  align="center" bgcolor="#ffffff">
				<tr>
					<td colspan="2">会员登录USER LOGIN <font color='red'>${msg }</font></td>
				</tr>
				<tr>
					<td>用户名</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td colspan='2'><input type="submit"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>