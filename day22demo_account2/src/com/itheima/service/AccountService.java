package com.itheima.service;

import java.sql.SQLException;

import com.itheima.c3p0ueils.ConnectionManager;
import com.itheima.dao.AccountDao;

/*
 *  业务层,转户数据的业务层
 *  调用dao层的方法out,in 实现转账
 *  被Web调用,传递账户名和金额
 */
public class AccountService {
	/*
	 * 定义方法,实现转账 web调用,传入账户名和金额 调用dao
	 */
	public void transfer(String outaname, String inaname, double menoy) {
		@SuppressWarnings("unused")
		AccountDao dao = new AccountDao();
		try {
			ConnectionManager.setAutoCommit();
			AccountDao.in(inaname, menoy);
			AccountDao.out(outaname, menoy);
			ConnectionManager.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				ConnectionManager.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectionManager.relase();
			}
		}
	}
}
