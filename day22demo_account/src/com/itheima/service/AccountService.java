package com.itheima.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.itheima.c3p0utils.C3P0Utils;
import com.itheima.dao.AccountDao;

/*
 *   业务层,转户数据业务层
 *   调用dao层out in 实现转账 
 *   被wep调用,传递账户名和金额
 */
public class AccountService {
	/*
	 * 定义方法,实现转账 web调用,传入账户名和金额 调用dao
	 */
	public void transfer(String outaname, String inaname, double menoy) {
		AccountDao dao = new AccountDao();
		Connection conn = null;
		try {
			conn = C3P0Utils.getConnection();
			conn.setAutoCommit(false);
			dao.in(conn, inaname, menoy);
			dao.out(conn, outaname, menoy);
			conn.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			C3P0Utils.relase(null, null, conn);
		}
	}
}
