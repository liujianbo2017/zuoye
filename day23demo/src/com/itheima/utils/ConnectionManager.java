package com.itheima.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {
	// ��Աλ�ô���ThreadLocal����
	private static ThreadLocal<Connection> local = new ThreadLocal<Connection>();

	public static Connection getConnection() {
		// local������ȥConnection
		Connection conn = local.get();
		if (conn == null) {
			conn = C3P0Utils.getConnection();
			local.set(conn);
		}
		return conn;
	}

	// ��������,��ֹ�����Զ��ύ
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
