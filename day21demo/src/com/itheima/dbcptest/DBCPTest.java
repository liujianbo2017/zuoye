package com.itheima.dbcptest;

import java.sql.Connection;

import com.itheima.c3p0utils.C3P0Utils;



/*
 *   测试DBCP连接池的工具类
 *   通过类的静态方法，获取连接 
 */
public class DBCPTest {
	public static void main(String[] args) {
		Connection conn = C3P0Utils.getConnection();
		System.out.println(conn);
	}
	

}
