package cn.itcast.day41.demo01;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class MyRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("请求对象被销毁");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		//通过事件对象,得到请求对象本身,从而得到当前请求的目标
		HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
		System.out.println("请求对象被初始化"+req.getRequestURI());
	}

}
