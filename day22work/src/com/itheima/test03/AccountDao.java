package com.itheima.test03;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

public class AccountDao {
	public void out(String name, double balance) throws SQLException {
		QueryRunner runner = new QueryRunner();
		String sql = "UPDATE account SET balance=balance-? WHERE name=?";
		int row = runner.update(ConnectionManager.getConnection(), sql, balance, name);
	}

	public void it(String name, double balance) throws SQLException {
		QueryRunner runner = new QueryRunner();
		String sql = "UPDATE account SET balance=balance+? WHERE name=?";
		int row = runner.update(ConnectionManager.getConnection(), sql, balance, name);
	}
}
