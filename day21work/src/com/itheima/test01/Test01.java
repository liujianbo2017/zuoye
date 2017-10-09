package com.itheima.test01;
//1.	创建连接池对象ComboPooledDataSource对象

//2.	设置连接参数（jdbcUrl，user，password，driverClass）
//3.	设置连接池参数
//4.	初始连接数initialPoolSize
//a)	最大连接数maxPoolSize
//b)	最大等待时间checkoutTimeout
//c)	最大空闲回收时间maxIdleTime
//5.	获取连接对象（getConnection() 方法）

import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Test01 {
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
		dataSource.setMaxPoolSize(20);
		// 最大等待时间checkoutTimeout
		dataSource.setCheckoutTimeout(3000);
		// 最大空闲回收时间maxIdleTime
		dataSource.setMaxIdleTime(1000);
		// 获取连接对象（getConnection() 方法）
		for (int i = 0; i < 10; i++) {
			Connection conn = dataSource.getConnection();
			System.out.println("第" + (i + 1) + "个:" + conn);
		}

	}

}
