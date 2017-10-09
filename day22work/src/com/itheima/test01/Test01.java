package com.itheima.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test01 {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day22work", "root", "root");
			conn.setAutoCommit(false);
			stat = conn.createStatement();
			String sql = "UPDATE account SET balance=balance+500 WHERE name='Jack'";
			String sql2 = "UPDATE account SET balance=balance-500 WHERE name='Rose'";
			int row = stat.executeUpdate(sql);
			int row2 = stat.executeUpdate(sql2);
			System.out.println(row);
			System.out.println(row2);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
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
