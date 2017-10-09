package com.itheima.c3p0utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 *  C3P0连接池,工具类
 *  返回数据库连接
 *  javax.sql.DataSource接口实现类
 *  c3p0类库中,ComboPooledDataSource接口实现类
 *  ComboPooledDataSource方法setXXX 配置数据库的四大信息
 *  
 *  C3P0配置文件中,XML配置,创建文件c3p0-config.xml
 *  存储在src中 会自动读取xml文件
 */
public class C3P0Utils {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (Exception ex) {
			throw new RuntimeException("数据库连接失败");
		}
	}

	/*
	 * 静态方法,返回DataSource接口实现类ComboPooledDataSource对象
	 */
	public static DataSource dataSource() {
		return dataSource;
	}

	public static void relase(ResultSet rs, Statement stat, Connection conn) {
		if (rs != null)
			try {
				rs.close();
			} catch (Exception ex) {
			}
		if (stat != null)
			try {
				stat.close();
			} catch (Exception ex) {
			}
		if (conn != null)
			try {
				conn.close();
			} catch (Exception ex) {
			}
	}

}
