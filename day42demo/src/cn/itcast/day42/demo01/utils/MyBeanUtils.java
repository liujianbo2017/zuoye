package cn.itcast.day42.demo01.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

public class MyBeanUtils {
	static{
		//创建转换器对象
		DateConverter dc = new DateConverter();
		//设置转换器支持的支持的日期格式
		dc.setPattern("yyyy-MM-dd");
		//在BeanUtils中注册此转换器，当需要把字符串转换成date时使用
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
