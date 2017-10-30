package cn.itcast.day49.demo04;

import java.lang.reflect.Method;

//实现仿JUNIT的工具类
public class MyJunit {

	public static void main(String[] args) throws Exception {
		//得到类对象
		Class clazz = TestMyJunit.class;
		
		//得到此类所有方法的对象
		Method[] method = clazz.getMethods();
		
		//创建测试类对象,便于调用测试方法
		Object obj = clazz.newInstance();
		
		//遍历所有方法对象
		for (Method method2 : method) {
			//判断当前方法上是否存在MyTest注释修饰
			if(method2.isAnnotationPresent(MyTest.class)){
				//如果有,则运行此方法
				method2.invoke(obj, null);
			}
		}
	}
}
