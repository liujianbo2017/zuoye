package cn.itcast.day36.demo02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestParamServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msg = req.getParameter("msg");
		//用重新编码的方式解决GEY方式提交的中文乱码问题
		//此方法可以解决POST方式的中文乱码问题
		msg = new String(msg.getBytes("IOS-8859-1"),"UTF-8");
		
		System.out.println("get:"+msg);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求对象的字符集来解决POST方式提交的中文乱码问题
		req.setCharacterEncoding("UTF-8");
		
		String msg = req.getParameter("msg");
		
		System.out.println("post:"+msg);
		
		//遗留问题：如果所有的Servlet要解决中文问题，都要设置字符集吗？
		//找一个统一的地方（Filter）设置，所有的Servlet就不用设置了
		//设置Tomcat的字符集
	}
	

}
