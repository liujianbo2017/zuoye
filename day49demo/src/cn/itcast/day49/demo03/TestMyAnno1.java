package cn.itcast.day49.demo03;

import java.util.List;

//如果注解有属性,那么使用时必须给属性赋值,除非属性有默认值
//如果只需要给value属性赋值，那么属性名可省略
//如果需要赋值的属性不止value一个，那么value的属性名不能省略
@Myanno1(value = 12, username = "admin", classes = {String.class,List.class})
public class TestMyAnno1 {

	@Myanno2
	public void test1(){
		
	}
	
	@Myanno2
	public void test2(){
		
	}
	
	public void test3(){
		
	}
	
	@Myanno2
	public void test4(){
		
	}
}
