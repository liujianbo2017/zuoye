package com.itheima.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.c3p0ueils.ConnectionManager;

public class AccountDao {
	public static void out(String aname, double menoy) throws SQLException {
		QueryRunner runner = new QueryRunner();
		String sql = "UPDATE account SET menoy=menoy-? WHERE aname=?";
		@SuppressWarnings("unused")
		int row = runner.update(ConnectionManager.getConnection(), sql, menoy, aname);
	}

	@SuppressWarnings("unused")
	public static void in(String aname, double menoy) throws SQLException {
		QueryRunner runner = new QueryRunner();
		String sql = "UPDATE account SET menoy=menoy+? WHERE aname=?";
		int row = runner.update(ConnectionManager.getConnection(), sql, menoy, aname);
	}

}