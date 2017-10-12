package com.itheima.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

public class MyBeanUtils {
	static{
		//创建转换器
		DateConverter dc = new DateConverter();
		//设置转换器支持的日期格式
		dc.setPattern("yyyy-MM-dd");
		//在BeanUtils中注册此转换器,当需要把字符串转换成date形式的时候,使用次转换器
		ConvertUtils.register(dc, java.util.Date.class);
	}
	public static void populate(Object bean, Map map){
		//使用BeanUtils工具类的方法将map中同名属性值封装到User中
		try {
			BeanUtils.populate(bean, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
