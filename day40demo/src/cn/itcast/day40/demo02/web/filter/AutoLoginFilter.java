package cn.itcast.day40.demo02.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import cn.itcast.day40.demo02.domain.User;
import cn.itcast.day40.demo02.service.UserService;
import cn.itcast.day40.demo02.service.impl.UserServiceImpl;
//实现自动登录过滤器
public class AutoLoginFilter implements Filter {
	//因为要调用业务逻辑所以过滤器中要持有Service对象
	private UserService userService = new UserServiceImpl();
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
		//对Request对象进行强制类型转换，使其可以调用HttpServletRequest对象中的方法
		HttpServletRequest req = (HttpServletRequest)request;
		//从Cookie中取得保存了用于自动登录的用户名和密码
		Cookie[] cookies = req.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if("autologin".equalsIgnoreCase(cookie.getName())){
					String t = cookie.getValue();
					String[] str = t.split("&");
					//调用业务逻辑，进行登录验证
					User user = userService.checkLogin(str[0], str[1]);
					//判断用户对象是否为空，不为空，则说明登录成功，
					if(user!=null){
						//把用户对象保存到Session域中，说明当前为已登录状态(名字固定为current_user)
						req.getSession().setAttribute("corrent_user", user);
					}
				}
			}
		}
		chain.doFilter(request, response);

	}

	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
