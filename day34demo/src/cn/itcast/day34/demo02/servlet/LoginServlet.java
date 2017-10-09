package cn.itcast.day34.demo02.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.day34.demo02.service.UserService;

public class LoginServlet extends HttpServlet{
	//创建业务层对象,方便调用业务层方法
	private UserService userService = new UserService();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     req.setCharacterEncoding("UTF-8");
		//接收数据,获取用户输入的用户名和密码
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//处理请求,调用业务逻辑,验证登录
		boolean flag = userService.login(username,password);
		//设置字符集,解决输出过程中的中文乱码问题
		resp.setContentType("text/html;charset=UTF-8");
		//根据结果,返回响应信息(登录成功/失败)
		resp.getWriter().write(flag ? "<h2>登录成功</h2>":"<font color='red'>登录失败,请重新输入</font>");
	}

}
