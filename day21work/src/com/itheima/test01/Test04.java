package com.itheima.test01;
//使用DBCP连接池获得10个连接对象，要求如下：
//1.纯代码编写配置信息(不使用配置文件)
//2.设置初始为5个，最大10个，最大等待时间3秒，最大空闲个数3个

import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Test04 {
	public static void main(String[] args) throws Exception {
		// 获得连接池对象
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		// 设置连接参数jdbcUrl，user，password，driverClass
		// 设置数据库连URL
		dataSource.setJdbcUrl("jdbc:mysql://loaclhose:3306/day21");
		// 设置数据驱动
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		// 设置密码
		dataSource.setUser("root");
		// 设置用户名
		dataSource.setPassword("root");
		// 设置初始连接数initialPoolSize
		dataSource.setInitialPoolSize(5);
		// 最大连接数maxPoolSize
		dataSource.setMaxPoolSize(10);
		// 最大等待时间checkoutTimeout
		dataSource.setCheckoutTimeout(3);
		// 最大空闲回收时间maxIdleTime
		dataSource.setMaxIdleTime(3);
		// 获取连接对象（getConnection() 方法）
		for (int i = 0; i < 10; i++) {
			Connection conn = dataSource.getConnection();
			System.out.println("第" + (i + 1) + "个:" + conn);
		}

	}

}

