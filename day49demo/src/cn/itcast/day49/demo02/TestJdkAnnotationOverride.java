package cn.itcast.day49.demo02;

public class TestJdkAnnotationOverride extends Human{

	//此方法必须是重写父类(JDK1.5),或者实现接口(JDK1.6),如果不是则编译错误
	@Override
	public void eat(){
		System.out.println("人会吃熟食");
	}
}
