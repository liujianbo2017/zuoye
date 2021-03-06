package cn.itcast.day40.demo02.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.day40.demo02.domain.User;
import cn.itcast.day40.demo02.service.UserService;
import cn.itcast.day40.demo02.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet{
	private UserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String str = req.getParameter("autologin");
		//调用业务逻辑，进行登录验证（如果登录成功，则返回用户对象，登录失败则返回null）
		User user = userService.checkLogin(username , password);
		resp.setContentType("text/html; charset=UTF-8");
		////如果登录成功，则把用户对象保存到Session域，以此说明当前是已登录状态
		if(user!=null){
			req.getSession().setAttribute("current_user", user);
			//判断用户是否勾选自动登录
			if("t".equals(str)){
				Cookie cookie = new Cookie("autologin", username+"&"+password);
				cookie.setMaxAge(12*24*60*60);
				resp.addCookie(cookie);
			}
			//转跳回首页(尽量使用重定向，因为之前是一个登录的表单提交，使用内部转发会产生登录表单的重复提交)
			resp.sendRedirect(req.getContextPath()+"/demo02/index.jsp");
		}else{
			//登录失败,返回登录页面
			req.getRequestDispatcher("/demo02.login.jsp").forward(req, resp);
		}
	}
	

}
