package cn.itcast.day52.demo03;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class BeanFactory {

	private static Document dc = null;
	static{
		//解析配置文件
		SAXReader reader = new SAXReader();
		try {
			dc = reader.read(BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml"));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//根据传入的id,得到对应的对象
	public static Object getBean(String id){
		//根据id得到xml中的元素
		Element element = dc.elementByID(id);
		
		String className = element.attributeValue("class");
		
		Class clazz;
		Object r = null;
		try {
			clazz = Class.forName(className);
			r = clazz.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
}
