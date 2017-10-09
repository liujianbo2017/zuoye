package com.itheima.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {
	// 成员位置创建ThreadLocal对象
	private static ThreadLocal<Connection> local = new ThreadLocal<Connection>();

	public static Connection getConnection() {
		// local方法回去Connection
		Connection conn = local.get();
		if (conn == null) {
			conn = C3P0Utils.getConnection();
			local.set(conn);
		}
		return conn;
	}

	// 创建方法,阻止事务自动提交
	public static void setAutoCommit() {
		try {
			getConnection().setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void commit() {
		try {
			getConnection().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void rollback() {
		try {
			getConnection().rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void relase() {
		try {
			getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		local.remove();
	}

}
