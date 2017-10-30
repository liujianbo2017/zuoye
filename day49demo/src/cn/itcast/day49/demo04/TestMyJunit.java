package cn.itcast.day49.demo04;

//用来测试MyTest注解及其运行功能的测试类
public class TestMyJunit {

	@MyTest
	public void test1(){
		System.out.println("用来测试方法一");
	}
	
	public void test2(){
		System.out.println("用来测试方法二");
	}
	
	@MyTest
	public void test3(){
		System.out.println("用来测试方法三");
	}
	
	@MyTest
	public void test4(){
		System.out.println("用来测试方法四");
	}
}
