package com.itheima.test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.itheima.c3p0utiils.C3P0Utils;

public class Test03 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = C3P0Utils.getConnection();
			conn.setAutoCommit(false);
			String sql = "UPDATE account SET balance=balance-? WHERE name=?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, 200);
			ps.setObject(2, "Jack");
			ps.executeUpdate();
//			System.out.println(5 / 0);
			String sql2 = "UPDATE account SET balance=balance+? WHERE name=?";
			ps = conn.prepareStatement(sql2);
			ps.setObject(1, 200);
			ps.setObject(2, "Rose");
			ps.executeUpdate();
			conn.commit();
			System.out.println("转账成功");
		} catch (SQLException ex) {
			ex.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("转账失败");
		} finally {
			C3P0Utils.relase(null, ps, conn);

		}
	}

}
