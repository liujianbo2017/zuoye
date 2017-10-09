package cn.itcast.day36.demo01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//测试Request对象获取请求行,请求头
public class TestServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//请求方式
		System.out.println("method"+req.getMethod());
		//请求的目标
		System.out.println("URI"+req.getRequestURI());
		System.out.println("URL"+req.getRequestURL());
		//协议版本
		System.out.println("Protocol"+req.getProtocol());
		//获得请求头
		System.out.println(req.getHeader("User-Agent"));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	

}
