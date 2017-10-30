package cn.itcast.day49.demo06;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//测试动态代理模型的测试类
public class TestProxy {

	public static void main(String[] args) {
		
		//创建原始对象
		final Human berryAlen = new NormalHuman();
		
		//创建一个代理对象
		Human flash = (Human) Proxy.newProxyInstance(
				TestProxy.class.getClassLoader(),//当前类的类加载器 
				new Class[]{Human.class},//要实现的接口的数组 
				new InvocationHandler() {//方法调用的处理器对象
					
					/*
					 * 当代理方法被调用时,使用此方法
					 * 参数:
					 * 		proxy:代理对象,一般不用.注意:一定不要调用此类的方法
					 * 		method:当前方法对象
					 * 		args:调用方法时传入参数 
					 */
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						//如果此方法不增强,则原样调用
						//判断当前方法的方法名,是否是要增强的方法
						if("run".equals(method.getName())){
							//是 ,就增强
							System.out.println("闪电侠以10倍光速奔跑");
						}else{
							//否,则不增强,调用原方法，注意：引用匿名内部类外面的局部变量时，局部变量必须是final修饰的
							System.out.println("调用方法: "+method.getName());
							return method.invoke(berryAlen,args);
							//所有动态代理比装饰者模式强就强在这里,不用手动去实现所有不需要增强方法,只用这一天语句就可以实现所有不需要增强的方法原样调用
						}
						return null;
					}
				});
		System.err.println("------------------------");
		flash.eat();
		flash.say();
		flash.run();
	}
}
