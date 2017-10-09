package cn.itcast.day34.demo01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet02
 */
public class TestServlet02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//调用父类继承此接口的方法,得到ServletConfig对象
		ServletConfig servletConfig = getServletConfig();
		//获取Servlet的名称
		System.out.println("Servlet name"+ servletConfig.getServletName());
		//取得Servlet的初始化参数,仅限于此Servlet有用
		String username = servletConfig.getInitParameter("username");
		System.out.println("Servlet init paramenter username"+username);
		//获取所有的初始化参数
		Enumeration<String> names = servletConfig.getInitParameterNames();
		//遍历此集合,判断是否还有没有被遍历过的元素
		while(names.hasMoreElements()){
			//得到此元素
		String name = names.nextElement();
		System.out.println( name + " -> " + servletConfig.getInitParameter(name));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
