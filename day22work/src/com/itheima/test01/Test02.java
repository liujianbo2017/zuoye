package com.itheima.test01;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.c3p0utiils.C3P0Utils;

public class Test02 {
	public static void main(String[] args) {
		QueryRunner runner = new QueryRunner();
		Connection conn = null;
		try{
			conn=C3P0Utils.getConnection();
			conn.setAutoCommit(false);
		String sql = "UPDATE account SET balance=balance+? WHERE name=?";
		String sql2 = "UPDATE account SET balance=balance-? WHERE name=?";
		int row = runner.update(conn, sql, 500,"Jack");
		int row2 = runner.update(conn, sql2, 500,"Rose");
		System.out.println(row);
		System.out.println(row2);
		conn.commit();
		}catch(SQLException ex){
			ex.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}finally{
			C3P0Utils.relase(null, null, conn);
		}
	}

}
