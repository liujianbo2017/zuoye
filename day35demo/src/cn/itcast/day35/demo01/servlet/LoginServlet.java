package cn.itcast.day35.demo01.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.day35.demo01.service.UserService;

public class LoginServlet extends HttpServlet{
	private UserService userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//接收请求,得到用户名和密码
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//处理请求
		boolean flag = userService.login(username, password);
		String msg = null;
		//做出响应,根据业务逻辑的结果,显示不同的结果
		if( flag ){
			//进行访问量的累加,计数器的类型使用Integer包装类而不能使用int基本类型,因为int不能接收null
			Integer count = (Integer)getServletContext().getAttribute("count");
			//判断是否为空
			if(count==null){
				//说明是第一次访问,所有设置count值为1
				count = 1;
			}else{
				//不为空count自增1
				count++;
			}
			//保存会域中
			getServletContext().setAttribute("count", count);
			//提示登录成功
			msg = "登录成功!您是第"+count+"位访客";
		}else{
			//提示登录失败
			msg = "登录失败!请重新输入";
		}
		resp.setContentType("text/html; charset=UTF-8");
		resp.getWriter().write(msg);
	}
	

}

