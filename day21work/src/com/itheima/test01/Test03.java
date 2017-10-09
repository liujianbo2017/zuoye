package com.itheima.test01;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//自定义C3P0工具类，要求如下：
//1.创建私有静态数据源(连接池对象)成员变量
//2.创建公有的得到数据源(连接池对象)的方法
//3.创建共有的得到连接对象的方法

public class Test03 {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
		throw new RuntimeException("数据库连接失败");
		}
	}

	public static DataSource dataSource() {
		return dataSource;
	}

}
