package cn.itcast.day44.demo05.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.day44.demo05.service.UserService;
import cn.itcast.day44.demo05.service.impl.UserServiceImpl;

//案例一: 验证用户名是否可用的异步请求的servlet
public class CheckUserNameServlet extends HttpServlet{

	private UserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接受请求,得到用户名
		String username = req.getParameter("username");
		
		//调用业务逻辑
		boolean flag = userService.isUsernameUsable( username );
		
		//根据结果发回响应内容给浏览器
		resp.getWriter().write(flag?"t":"f");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
