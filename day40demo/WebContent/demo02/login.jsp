<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/login.servlet" method="post">
		<table align="center">
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="checkbox" name="autologin" value="t" id="al"/>
					<label for="al">两周之内免登陆,请不要在公共网络上登录</label>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="登录"/>
					<input type="reset"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>