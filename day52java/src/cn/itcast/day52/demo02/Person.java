package cn.itcast.day52.demo02;

public class Person {

	//人持有斧头,斧头是和工厂要的
	private Axe axe = AxeFactory.getAxe();
	
	//人会使用斧头
	public void useAxe(){
		axe.chopTree();
	}
	
	public static void main(String[] args) {
		Person p = new Person();
		p.useAxe();
	}
}
