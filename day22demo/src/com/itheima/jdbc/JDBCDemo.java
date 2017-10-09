package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 *   JDBC技术,实现模拟转账操作
 *     两个update语句,放在一组执行,都成功,或者都失败
 *     数据库: 多个SQL语句算做一组,必须是同一个Connection连接执行
 *     账户表,原兽平台转账到楚风  1000
 *     
 *   使用事务,保证安全性,
 *     开启事务
 *     程序没有任何问题,提交事务,数据持久
 *     程序出现问题,回滚事务,数据退回到原始状态
 *     
 *   Connection接口定义了三个操作事务方法
 *      setAutoCommit(false)阻止事务自动提交
 *      commit() 提交事务
 *      rollback() 回滚事务
 *      
 *   SQL语句执行操作之前,开启事务
 *   SQL语句执行完毕后,无问题,提交事务(不出异常)
 *   SQL语句执行出现问题,回滚事务(抛出异常)
 * 
 */
public class JDBCDemo {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day22", "root", "root");
			conn.setAutoCommit(false);
			stat = conn.createStatement();
			String sql = "UPDATE account SET menoy=menoy+1000 WHERE aname='楚风'";
			String sql2 = "UPDATE account SET menoy=menoy-1000 WHERE aname='原兽平台'";
			int row = stat.executeUpdate(sql);
			int row2 = stat.executeUpdate(sql2);
			System.out.println(row);
			System.out.println(row2);
			conn.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			if (stat != null)
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

}
