package cn.itcast.estore.web.servlet;

//专门用于导入静态常量
import static cn.itcast.estore.constant.Constant.SESSION_USERNAME;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.estore.domain.User;
import cn.itcast.estore.utils.MyBeanUtils;
import cn.itcast.estore.web.servlet.base.BaseServlet;

//处理用户信息的Servlet
public class UserServlet extends BaseServlet {


	//转跳到注册页面的Servlet
	public String goRegistUI(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
		
		return "/register.jsp";
	}
	//转跳到注册页面的Servlet
	public String goLoginUI(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
			
		return "/login.jsp";
	}
	
	//进行用户注册的方法
	public String regist(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
		//接受请求,并封装
		User user = new User();
		MyBeanUtils.populate(user, req.getParameterMap());
		
		//调用业务层方法,返回布尔值表示是是否成功
		boolean flag = userService.regist( user );
		
		//转跳到信息页面显示结果（根据结果布尔值显示注册成功或失败）
		req.setAttribute("msg", flag ? "注册成功! 请到注册邮箱中接收激活邮件进行激活后登录网站。":"注册失败! 请联系客服人员");
		
		return "/info.jsp";
	}
	
	//激活用户的方法
	public String active(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//接受请求,得到激活码
		String code = req.getParameter("code");
		
		//调用业务逻辑,进行激活
		boolean flag = userService.active(code);
		
		//转跳到信息页面显示结果（根据结果布尔值显示注册成功或失败）
		req.setAttribute("msg", flag?"激活成功!请登录":"激活失败!请联系客服人员");
		
		return "/info.jsp";
	}
	
	//用户登录的方法
		public String login(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
			//接受请求,得到数据
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String autoLogin = req.getParameter("autoLogin1");
			String remember = req.getParameter("remember1");
			//调用业务逻辑,进行激活
			User user = userService.login(username , password);
			String path;
			if( user != null){
				//把用户对象保存到Session域中（以固定的名）
				req.getSession().setAttribute( SESSION_USERNAME, user );
				//因为是一个登录的表单提交到达的当前Servlet，要转跳到首页，而首页中可能需要进行刷新
				//为了防止出现表单重复提交的问题，所以这里使用重定向回到首页
				//返回的字符串以项目名开头，所以会使用重定向，因为设置了默认访问首页，所以只有项目名即可
				//如果登录成功
				path = req.getContextPath();
			}else{
				req.setAttribute("msg", "登录失败!请重新登录");
				path = "/login.jsp";
			}
			//判断用户是否勾选自动登录
			if("t".equals(autoLogin)){
				//创建Cookie对象
				Cookie c = new Cookie("autoLogin1", username+"&"+password);
				//设置失效时间
				c.setMaxAge(30*24*60*60);
				//添加到Cookie中
				resp.addCookie(c);
			}
			return path;
		}

		public String goRemoveUI(HttpServletRequest req, HttpServletResponse resp) throws Exception {
			//删除Session域中的用户名
			req.getSession().removeAttribute(SESSION_USERNAME);
			//创建Cookie对象
			Cookie c = new Cookie("autoLogin1",0+"&"+0);
			//添加到Cookie中
			resp.addCookie(c);
			return "/index.jsp";
		}
}
