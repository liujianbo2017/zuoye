package com.itheima.test02;

import java.sql.Connection;
import java.sql.SQLException;

import com.itheima.c3p0utiils.C3P0Utils;

public class AccountService {
	public void transfer(double balance,String outname,String inname){
		AccountDao dao = new AccountDao();
		Connection conn =null;
		try{
			conn=C3P0Utils.getConnection();
			conn.setAutoCommit(false);
			dao.out(conn, balance, outname);
			dao.in(conn, balance, inname);
			conn.commit();
		}catch(SQLException ex){
			ex.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}finally{
			C3P0Utils.relase(null, null, conn);
		}
	}

}
