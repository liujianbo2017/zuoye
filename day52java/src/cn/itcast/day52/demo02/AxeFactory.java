package cn.itcast.day52.demo02;

import java.io.IOException;
import java.util.Properties;

public class AxeFactory {

	public static Class clazz = null;
	
	//简单静态工厂
	static{
		Properties p = new Properties();
		try {
			p.load(AxeFactory.class.getClassLoader().getResourceAsStream("axe.properties"));
			//读取配置文件文件中的class类名
			String className = p.getProperty("class");
			//根据类名得到字节码
			clazz = Class.forName(className);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//得到斧头的方法
	public static Axe getAxe(){
		Axe axe = null;
		try {
			axe = (Axe) clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return axe;
	}
}
