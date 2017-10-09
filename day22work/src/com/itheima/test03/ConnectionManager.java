package com.itheima.test03;

import java.sql.Connection;
import java.sql.SQLException;

import com.itheima.c3p0utiils.C3P0Utils;

public class ConnectionManager {
	//// 成员位置创建ThreadLocal对象
	private static ThreadLocal<Connection> local = new ThreadLocal<Connection>();

	// 创建方法,获取连接对象,从local中获取
	public static Connection getConnection() {
		// local对象回去get()获取连接对象
		Connection conn = local.get();
		if (conn == null) {
			conn = C3P0Utils.getConnection();
			// local对象调用set()方法存储
			local.set(conn);
		}
		return conn;
	}

	// 创建方法,阻止事务自动提交
	public static void setAutoCommit() throws SQLException {
		getConnection().setAutoCommit(false);
	}
	//创建方法,提交事务
	public static void Commit() throws SQLException{
		getConnection().commit();
	}
	//创建方法,回滚事务
	public static void Rollback() throws SQLException{
		getConnection().rollback();
	}
	//创建方法,释放资源
    public static void relase(){
    	try {
			getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    		
    }

}
