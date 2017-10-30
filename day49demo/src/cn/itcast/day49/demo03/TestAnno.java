package cn.itcast.day49.demo03;

import java.lang.reflect.Method;

import org.junit.Test;

//测试解析注解
public class TestAnno {

	@Test
	public void test1(){
		//得到字节码对象
		Class clazz = TestMyAnno1.class;
		
		//得到此类中的所有方法对象
		Method[] methods = clazz.getMethods();
		//遍历所有的方法对象
		for (Method method : methods) {
			//通过调用接口方法,测试此方法上是否存在MyAnno2注释的修饰
			boolean flag = method.isAnnotationPresent(Myanno2.class);
			System.out.println(method.getName()+" : "+ flag);
		}
	}
}
