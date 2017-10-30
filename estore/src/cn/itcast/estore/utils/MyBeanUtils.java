package cn.itcast.estore.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

public class MyBeanUtils {

	static{
		//设置转换器对象
		DateConverter dc = new DateConverter();
		//设置转换器支持的日期格式
		dc.setPattern("yyyy-MM-dd");
		//在BeanUtils中注册此转换器,当需要使用转换日期格式的时候使用次转换器
		ConvertUtils.register(dc, java.util.Date.class);
	}
	
	public static void populate(Object obj, Map map){
		try {
			BeanUtils.populate(obj, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
