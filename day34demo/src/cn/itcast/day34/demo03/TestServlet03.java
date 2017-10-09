package cn.itcast.day34.demo03;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet03 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//得到ServletContext对象(父类实现这个方法)
		ServletContext sc = getServletContext();
		//是一个域对象(当Map用)
		//保存到ServletContext
		sc.setAttribute("temp", "Hello String in Servlet Context!");
		System.out.println(sc.getAttribute("temp"));
		
		//取得初始化参数(不常用)
		String P = sc.getInitParameter("TestSC");
		System.out.println("testSC:"+P);
		
		//动态获取当前项目名
		System.out.println(sc.getContextPath());
		
		//进行路径的转换（把WEB路径转换成绝对路径）
		//传入一个服务端的WEB路径，返回一个绝对路径（文件可以不存在)
		System.out.println(sc.getRealPath("/demo02/bbb/aaa.html"));
		//取得指定WEB路径中的文件的输入流(文件必须存在)
		System.out.println(sc.getResourceAsStream("/demo02//demo2/login.html"));
	}
	

}
