package cn.itcast.day40.demo04;
//超能力人的类,相当于被包装的类
public class MetaHuman implements Human {
	//持有原始被增强的对象
	private Human h;
	//通过构造器得到原始对象
	public MetaHuman(Human h){
		this.h = h;
	}
	@Override
	public void eat() {
		//调用原始对象的方法，相当于是在实现没有被增强的那些方法
		h.eat();

	}

	@Override
	public void say() {
		//调用原始对象的方法，相当于是在实现没有被增强的那些方法
		h.say();
	}

	@Override
	public void run() {
		//需要增强的方法可以自己实现，也可以调用原始方法，在其基础上进行增强
		//h.run();
		System.out.println("闪电侠以十倍的光速奔跑");

	}

}
