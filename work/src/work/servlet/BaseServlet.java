package work.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//由页面提交的方法名,也就是说,当用户要发送一个请求时,除了请求的参数外,还要加上一个method,值为要分发的方法名
		String methodName = req.getParameter("method");
		
		if(methodName == null || "".equals(methodName)){
			//如果提交的方法名为空,则执行默认方法execute
			methodName = "execute";
		}
		
		//使用反射机制,得打提交的同名方法对象,调用该方法
		//因为要得到的方法是属于子类的,本类是父类,实际运行时,当前对象this就是子类对象
		Class clazz = this.getClass();
		try {
			Method method = clazz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			
			//调用指定的方法,返回要跳转的页面的路径(如果需要内部转发,此此路径不是以项目名开头的.如果需要重定向,此路径以项目名开头)
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
