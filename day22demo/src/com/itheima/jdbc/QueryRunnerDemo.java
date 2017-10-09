package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.c3p0utils.C3P0Utils;

/*
 *  DBUtils实现事务管理
 *  创建QueryRunner对象,空参数构造方法
 *  调用update方法,手动传递连接对象
 *  获取连接,c3p0工具类获取
 *  事务自己手动控制的
 */
public class QueryRunnerDemo {
	public static void main(String[] args) {
		// 创建QueryRunner对象,无参数构造
		QueryRunner runner = new QueryRunner();
		Connection conn = null;
		try {
			conn = C3P0Utils.getConnection();
			conn.setAutoCommit(false);
			String sql = "UPDATE account SET menoy=menoy+? WHERE aname=?";
			String sql2 = "UPDATE account SET menoy=menoy-? WHERE aname=?";
			int row = runner.update(conn, sql, 1000, "楚风");
			int row2 = runner.update(conn, sql2, 1000, "原兽平台");
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
		}
	}

}
