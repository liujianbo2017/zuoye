package com.itheima.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.itheima.c3p0utils.C3P0Utils;
import com.itheima.dao.AccountDao;

/*
 *   ҵ���,ת������ҵ���
 *   ����dao��out in ʵ��ת�� 
 *   ��wep����,�����˻����ͽ��
 */
public class AccountService {
	/*
	 * ���巽��,ʵ��ת�� web����,�����˻����ͽ�� ����dao
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
