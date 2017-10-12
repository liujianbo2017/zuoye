package cn.itcast.day40.demo03;

public class Test {
	public static void main(String[] args) {
		Human h = new Human();
		h.eat();
		h.say();
		h.run();
		System.out.println();
		MetaHuman mh = new MetaHuman();
		mh.eat();
		mh.say();
		mh.run();
	}

}
