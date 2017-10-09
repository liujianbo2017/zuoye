package com.itheima.c3p0ueils;

import java.sql.Connection;
import java.sql.SQLException;

/*
 *   ʵ�����Ӷ��������
 *     ���Ӷ���,�洢���̵߳ľֲ�������
 *     ThreadLocal���� set
 *     
 *    ʵ���������
 *       �����Զ��ύ
 *       �ύ
 *       �ع�
 *       �ͷ���Դ
 */
public class ConnectionManager {
	// ��Աλ�ô���ThreadLocal����
	private static ThreadLocal<Connection> local = new ThreadLocal<Connection>();

	// ��������,��ȡ���Ӷ���,��local�л�ȡ
	public static Connection getConnection() {
		// local���󷽷�get()��ȡ���Ӷ���
		Connection conn = local.get();
		if (conn == null) {
			conn = C3P0Utils.getConnection();
			// local����,���÷���set�洢����
			local.set(conn);
		}
		return conn;
	}

	// ��������,��ֹ�����Զ��ύ
	public static void setAutoCommit() throws SQLException {
		// ���Ӷ���ķ���setAutoCommit(false)
		getConnection().setAutoCommit(false);
	}

	// ��������,�ύ����
	public static void commit() throws SQLException {
		// ���Ӷ��󷽷�Commit()
		getConnection().commit();
	}

	// ��������,�ع�����
	public static void rollback() throws SQLException {
		// ���Ӷ��󷽷�rollback()
		getConnection().rollback();
	}

	// ��������,�ͷ���Դ
	public static void relase() {
		try {
			getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		local.remove();
	}

}
