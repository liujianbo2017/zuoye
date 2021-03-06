package cn.itcast.day41.demo01;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class MyRequestAttributeListener implements ServletRequestAttributeListener{

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("请求域中发生了添加事件" + srae.getName()+"-->"+srae.getValue());
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("请求域中发生了移除事件" + srae.getName()+"-->"+srae.getValue());
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("请求域中发生了替换事件" + srae.getName()+"-->"+srae.getValue()+"-->"+srae.getServletRequest().getAttribute(srae.getName()));
	}

}
