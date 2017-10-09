package com.itheima.test02;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

public class AccountDao {
	public void out(Connection conn, double balance, String name) throws SQLException {
		QueryRunner runner = new QueryRunner();
		String sql = "UPDATE account SET balance=balance-? WHERE name=?";
		int row = runner.update(conn, sql, balance, name);
	}

	public void in(Connection conn, double balance, String name) throws SQLException {
		QueryRunner runner = new QueryRunner();
		String sql = "UPDATE account SET balance=balance+? WHERE name=?";
		int row = runner.update(conn, sql, balance, name);
	}

}
