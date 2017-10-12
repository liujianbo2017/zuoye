package cn.itcast.day41.demo02;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MySessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("监听域中发生添加事件"+se.getName()+"-->"+se.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("监听域中发生移除事件"+se.getName()+"-->"+se.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("监听域中发生添加事件"+se.getName()+"-->"+se.getValue());
	}

}
