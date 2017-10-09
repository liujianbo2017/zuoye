package cn.itcast.day36.demo03.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

public class MyBeanUtils {
	static{
		//创建日期转换器对象
		DateConverter dc = new DateConverter();
		//设置转换器支持的日期形式
		dc.setPattern("yyyy-MM-dd");
		//在BeanUtils中注册此转换器，当需要把字符串转换成Date对象时，使用此转换器
		ConvertUtils.register(dc, java.util.Date.class);
	}
	public static void populate(Object bean,Map map){
		//使用BeanUtils工具类的方法把Map中的同名属性值封装到User对象中
		try {
			BeanUtils.populate(bean, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
