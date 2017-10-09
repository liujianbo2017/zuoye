package com.itheima.service;

import java.sql.SQLException;

import com.itheima.c3p0ueils.ConnectionManager;
import com.itheima.dao.AccountDao;

/*
 *  ҵ���,ת�����ݵ�ҵ���
 *  ����dao��ķ���out,in ʵ��ת��
 *  ��Web����,�����˻����ͽ��
 */
public class AccountService {
	/*
	 * ���巽��,ʵ��ת�� web����,�����˻����ͽ�� ����dao
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
