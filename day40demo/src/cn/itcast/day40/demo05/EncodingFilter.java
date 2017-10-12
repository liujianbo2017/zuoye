package cn.itcast.day40.demo05;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//解决Post中文乱码问题
		request.setCharacterEncoding("UTF-8");
		
		//解决GET方式的中文乱码问题
		//使用包装类来增强原始的Request对象
		HttpServletRequest req = new MyRequest((HttpServletRequest)request);
		
		//放行，把原始对象替换为包装类的对象进行放行，
		//这样Servlet/JSP中得到的就是增强（包装）后的HttpServletRequest对象（getParameter方法已经被增强了）
		chain.doFilter(req, response);

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
