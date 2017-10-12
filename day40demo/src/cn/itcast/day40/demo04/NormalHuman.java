package cn.itcast.day40.demo04;
//普通人的类,相当于被包装的类
public class NormalHuman implements Human {

	@Override
	public void eat(){
		System.out.println("人会吃饭");
	}
	
	@Override
	public void say(){
		System.out.println("人会说话");
	}
	
	@Override
	public void run(){
		System.out.println("人能以10m/s的速度奔跑");
	}

}
