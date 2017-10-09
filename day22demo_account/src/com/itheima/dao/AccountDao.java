package com.itheima.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

/*
 *  dao�㴴����AccountDao,ʵ��������ݱ�account��CURD 
 *  ����,���˻�,���˻�
 *  �˻���,���
 *  ������DBUtils,�����Լ���ȡ����
 *  ���ݿ�����,ʹ��Service�㴫�ݹ���
 */
public class AccountDao {
	public void out(Connection conn, String aname, double menoy) throws SQLException {
		QueryRunner runner = new QueryRunner();
		// ƴд-Ǯ��SQL
		String sql = "UPDATE account SET menoy=menoy-? WHERE aname=?";
		int row = runner.update(conn, sql, menoy, aname);
	}

	public void in(Connection conn, String aname, double menoy) throws SQLException {
		QueryRunner runner = new QueryRunner();
		// ƴд+Ǯ��SQL
		String sql = "UPDATE account SET menoy=menoy+? WHERE aname=?";
		int row = runner.update(conn, sql, menoy, aname);
	}

}
