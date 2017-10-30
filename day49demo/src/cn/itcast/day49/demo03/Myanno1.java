package cn.itcast.day49.demo03;

//一个自定义的数组
public @interface Myanno1 {

	//注解中的属性:给属性设置默认值为root
	public String username();
	public int value();
	@SuppressWarnings("rawtypes")
	public Class[] classes();//可以是一维数组
}
