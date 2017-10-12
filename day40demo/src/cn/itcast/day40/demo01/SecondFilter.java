package cn.itcast.day40.demo01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("初始化第二个过滤器");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("请求到达第二个过滤器,放行前的部分");
		chain.doFilter(request, response);
		System.out.println("请求到达第二个过滤器,放行后的部分");

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("销毁第二个过滤器");

	}

}
