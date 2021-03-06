package com.itheima.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.User;
import com.itheima.service.UserService;

public class LoginServlet extends HttpServlet{
	private UserService userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = userService.login(username, password);
		resp.setContentType("text/html; charset=UTF-8");
		//3.页面跳转
		if(user == null){
			//没有找到 生成提示
			req.setAttribute("msg", "用户名和密码不匹配");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			
		}else{
			//找到
			req.getSession().setAttribute("user", user);
			resp.sendRedirect(req.getContextPath());
		}

	}
}
