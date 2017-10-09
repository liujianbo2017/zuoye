package com.itheima.test01;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//使用C3P0连接池获得10个连接对象。
//要求：分别使用默认配置和命名配置创建连接池对象。再通过连接池对象获得连接对象。

public class Test02 {
	public static void main(String[] args) throws SQLException {
		test01();
	}
	// 使用默认配置(default-config)
	public static  void test01() throws SQLException{
		ComboPooledDataSource dataSource = new  ComboPooledDataSource();
		for (int i = 0; i < 10; i++) {
			Connection conn = dataSource.getConnection();
			System.out.println("第" + (i + 1) + "个:" + conn);
			if(i==3){
				conn.close();
			}
		}
	}
	//使用命名配置(named-config)
	public static void test01_2() throws SQLException{
		ComboPooledDataSource dataSource = new ComboPooledDataSource("named-config");
		for (int i = 0; i <10; i++) {
			Connection conn = dataSource.getConnection();
			System.out.println("第" + (i + 1) + "个:" + conn);
		}
	}

}
