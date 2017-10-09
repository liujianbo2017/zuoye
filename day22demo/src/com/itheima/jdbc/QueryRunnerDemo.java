package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.c3p0utils.C3P0Utils;

/*
 *  DBUtilsʵ���������
 *  ����QueryRunner����,�ղ������췽��
 *  ����update����,�ֶ��������Ӷ���
 *  ��ȡ����,c3p0�������ȡ
 *  �����Լ��ֶ����Ƶ�
 */
public class QueryRunnerDemo {
	public static void main(String[] args) {
		// ����QueryRunner����,�޲�������
		QueryRunner runner = new QueryRunner();
		Connection conn = null;
		try {
			conn = C3P0Utils.getConnection();
			conn.setAutoCommit(false);
			String sql = "UPDATE account SET menoy=menoy+? WHERE aname=?";
			String sql2 = "UPDATE account SET menoy=menoy-? WHERE aname=?";
			int row = runner.update(conn, sql, 1000, "����");
			int row2 = runner.update(conn, sql2, 1000, "ԭ��ƽ̨");
			System.out.println(row);
			System.out.println(row2);
			conn.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
