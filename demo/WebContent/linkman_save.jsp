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
		<form method="post" action="${pageContext.request.contextPath }/regist.servlet">
			<table width="60%" height="60%"  align="center" bgcolor="#ffffff">
				<tr>
					<td colspan="2">新增联系人 <font color='red'></font></td>
				</tr>
				<tr>
					<td>联系人名称</td>
					<td><input name="lkm_name"></td>
				</tr>
				<tr>
					<td>联系人性别</td>
					<td>
						<input type="radio" name="lkm_gender" value="男">男
						<input type="radio" name="lkm_gender" value="女">女
					</td>
				</tr>
				<tr>
					<td>联系人电话</td>
					<td><input name="lkm_mobile"></td>
				</tr>
				<tr>
					<td>联系人邮箱</td>
					<td><input name="lkm_email"></td>
				</tr>
				<tr>
					<td>联系人QQ</td>
					<td><input name="lkm_qq"></td>
				</tr>
				<tr>
					<td colspan='2'><input type="submit" value="注册"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>