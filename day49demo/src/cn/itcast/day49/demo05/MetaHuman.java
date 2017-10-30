package cn.itcast.day49.demo05;

//超能力人类,实现了和普通人类的接口,需要增强run方法
public class MetaHuman implements Human{

	private Human human;
	
	//通过构造器得到并持有原始(被增强)对象
	public MetaHuman(Human human){
		this.human = human;
	}
	
	//不增强的方法需要调用原始对象的同名方法来实现
	//装饰者模式的缺点就在于需要手动实现所有不增强的方法的原样调用,一个接口中有200个方法的话就要实现200个方法的原样调用
	@Override
	public void eat() {
		this.human.eat();
	}

	@Override
	public void say() {
		this.human.say();
	}

	//需要增强的方法可以自己重新实现,也可以调用原始方法在增强
	@Override
	public void run() {
		System.out.println("闪电侠以10倍光速奔跑");
	}

}
