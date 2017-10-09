package com.itheima.c3p0ueils;

import java.sql.Connection;
import java.sql.SQLException;

/*
 *   实现连接对象管理类
 *     连接对象,存储在线程的局部变量中
 *     ThreadLocal类中 set
 *     
 *    实现事务管理
 *       控制自动提交
 *       提交
 *       回滚
 *       释放资源
 */
public class ConnectionManager {
	// 成员位置创建ThreadLocal对象
	private static ThreadLocal<Connection> local = new ThreadLocal<Connection>();

	// 创建方法,获取连接对象,从local中获取
	public static Connection getConnection() {
		// local对象方法get()获取连接对象
		Connection conn = local.get();
		if (conn == null) {
			conn = C3P0Utils.getConnection();
			// local对象,调用方法set存储连接
			local.set(conn);
		}
		return conn;
	}

	// 创建方法,阻止事务自动提交
	public static void setAutoCommit() throws SQLException {
		// 连接对象的方法setAutoCommit(false)
		getConnection().setAutoCommit(false);
	}

	// 创建方法,提交事务
	public static void commit() throws SQLException {
		// 连接对象方法Commit()
		getConnection().commit();
	}

	// 创建方法,回滚事务
	public static void rollback() throws SQLException {
		// 连接对象方法rollback()
		getConnection().rollback();
	}

	// 创建方法,释放资源
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
