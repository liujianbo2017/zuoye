package cn.itcast.day49.demo01;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//使用动态代理方式解决中文乱码问题
@WebFilter("*.servlet")
public class EncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//为了能够调用到HttpServletRequest接口中的方法,所有对Request对象进行类型强转
		//因为是在匿名内部类中调用,所有此对象的类型必须加final修饰
		final HttpServletRequest request2 = (HttpServletRequest)request;
		
		//解决POST方式的提交参数的中文乱码问题
		request.setCharacterEncoding("UTF-8");
		//解决响应信息中的中文乱码问题
		response.setCharacterEncoding("UTF-8");
		
		//创建一个实现HttpServletRequest接口的代理对象
		HttpServletRequest req = (HttpServletRequest)Proxy.newProxyInstance(
				this.getClass().getClassLoader(),//当前类的类加载器 
				new Class[]{HttpServletRequest.class}, //要实现的接口的数组
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// 调用原始方法,得到返回值
						Object obj = method.invoke(request2, args);
						
						//判断当前要执行的方法是否是getParameter方法
						if("getParameter".equals(method.getName())){
							//判断当前的提交方法是否是GET
							if("GET".equalsIgnoreCase(request2.getMethod())){
								//提交的参数有可能为空
								if(obj!=null){
									//当前getParameter方法的返回值是字符串,所以可以强转
									String result = (String)obj;
									//重新编码
									obj = new String(result.getBytes("ISO-8859-1"),"UTF-8");
								}
							}
						}
						//不需要增强的其他方法,调用原来对象的同名方法,返回原值
						return obj;
					}
				});
		//放行,把新生成的代理对象放过去
		chain.doFilter(req, response);

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
