package cn.itcast.day43.demo01.web.filter;

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
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//解决post中文乱码问题
		request.setCharacterEncoding("UTF-8");
		
		//解决get中文乱码问题
		HttpServletRequest req = new MyRequest((HttpServletRequest)request);
		
		chain.doFilter(req, response);

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
