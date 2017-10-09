package com.itheima.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

/*
 *  dao层创建类AccountDao,实现类对数据表account的CURD 
 *  方法,进账户,出账户
 *  账户名,金额
 *  工具类DBUtils,必须自己获取连接
 *  数据库连接,使用Service层传递过来
 */
public class AccountDao {
	public void out(Connection conn, String aname, double menoy) throws SQLException {
		QueryRunner runner = new QueryRunner();
		// 拼写-钱的SQL
		String sql = "UPDATE account SET menoy=menoy-? WHERE aname=?";
		int row = runner.update(conn, sql, menoy, aname);
	}

	public void in(Connection conn, String aname, double menoy) throws SQLException {
		QueryRunner runner = new QueryRunner();
		// 拼写+钱的SQL
		String sql = "UPDATE account SET menoy=menoy+? WHERE aname=?";
		int row = runner.update(conn, sql, menoy, aname);
	}

}
