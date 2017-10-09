package com.itheima.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

public class MyBeanUtils {
	static{
		DateConverter dc = new DateConverter();
		dc.setPattern("yyyy-MM-dd");
		ConvertUtils.register(dc, java.util.Date.class);
	}
	public static void populate(Object bean, Map map){
		try {
			BeanUtils.populate(bean, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
