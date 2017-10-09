package com.itheima.c3p0utiils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	public static DataSource dataSource(){
		return dataSource;
	}
	public static Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("数据库连接失败");
		}
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
