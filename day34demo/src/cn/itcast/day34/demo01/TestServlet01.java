package cn.itcast.day34.demo01;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//测试使用实现一个Servlet接口的方式创建一个Servlet类
public class TestServlet01 implements Servlet {

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("test Servlet 初始化...");
		
	}
	@Override
	public void destroy() {
		System.out.println("Test Servlet 实施销毁");

	}
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("Test Servlet 接收到请求");
		
	}

	
	
	
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}



}
