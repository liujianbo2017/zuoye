package cn.itcast.day40.demo04;


public class Test {
	public static void main(String[] args) {
		//实例化原始对象
		Human berryAlen = new NormalHuman();
			berryAlen.eat();
			berryAlen.say();
			berryAlen.run();
			
			System.out.println();
			Human flash = new MetaHuman( berryAlen );
			flash.eat();
			flash.say();
			flash.run();
	}

}
