package cn.itcast.day49.demo02;

import java.util.Date;

public class TestJdkAnnotationDeprecated {

	@Deprecated
	public void test(){
		System.out.println("这是一个过时的方法");
	}
	
	@SuppressWarnings("deprecation")
	public void test2(){
		//被标记过时的方法依然可以用(有缺陷,被新方法取代)
		test();
		Date date = new Date();
		date.getDate();
	}
}
