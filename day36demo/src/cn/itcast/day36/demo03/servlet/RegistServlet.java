package cn.itcast.day36.demo03.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.day36.demo03.damain.User;
import cn.itcast.day36.demo03.service.UserService;
import cn.itcast.day36.demo03.utils.MyBeanUtils;

public class RegistServlet extends HttpServlet{
	private UserService userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//接收请求，得到用户注册信息并封装成User对象
		User user = new User();
		MyBeanUtils.populate(user, req.getParameterMap());
		//调用业务逻辑，进行用户注册（写入数据库）
		boolean flag = userService.regist(user);
		//把提示信息保存到Request域
		req.setAttribute("msg", flag? "注册成功":"注册失败");
		//内部转发到信息页面
		req.getRequestDispatcher("/demo03/msg.jsp").forward(req, resp);
	}
	

}
