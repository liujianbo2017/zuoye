package cn.itcast.day49.demo06;

public class NormalHuman implements Human {

	@Override
	public void eat() {
		System.out.println("人会吃饭");
	}

	@Override
	public void say() {
		System.out.println("人会说话");
	}

	@Override
	public void run() {
		System.out.println("人会以10米每秒的速度奔跑");
	}

}
