package com.itheima.test03;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

public class AccountService {
	public void transfer(String outname, String inname, double balance) {
		AccountDao dao = new AccountDao();
		try {
			ConnectionManager.getConnection().setAutoCommit(false);
			dao.out(outname, balance);
			dao.it(inname, balance);
			ConnectionManager.getConnection().commit();
		} catch (SQLException ex) {
			ex.printStackTrace();
			try {
				ConnectionManager.getConnection().rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} finally {
			ConnectionManager.relase();
		}
	}

}
