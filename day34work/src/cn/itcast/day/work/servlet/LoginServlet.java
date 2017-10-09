package cn.itcast.day.work.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.day.work.service.UserService;

public class LoginServlet extends HttpServlet{
	private UserService userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
		//获得用户输入的用户名和密码
		String username = req.getParameter("usernaem");
		String password = req.getParameter("password");
		//调用业务层的方法
		boolean flag = userService.login(username,password);
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().write(flag ? "<h2>登录成功</h2>":"<font color='red'>登录失败,请重新输入</font>");
	}
	

}
