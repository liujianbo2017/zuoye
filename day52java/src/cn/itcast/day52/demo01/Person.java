package cn.itcast.day52.demo01;

public class Person {

	//人自己持有
	private StoneAxe axe = new StoneAxe();
	
	//人会使用斧子
	public void useAxe(){
		axe.chopTree();
	}
}
