package com.itheima.test03;

import java.sql.Connection;
import java.sql.SQLException;

import com.itheima.c3p0utiils.C3P0Utils;

public class ConnectionManager {
	//// ��Աλ�ô���ThreadLocal����
	private static ThreadLocal<Connection> local = new ThreadLocal<Connection>();

	// ��������,��ȡ���Ӷ���,��local�л�ȡ
	public static Connection getConnection() {
		// local�����ȥget()��ȡ���Ӷ���
		Connection conn = local.get();
		if (conn == null) {
			conn = C3P0Utils.getConnection();
			// local�������set()�����洢
			local.set(conn);
		}
		return conn;
	}

	// ��������,��ֹ�����Զ��ύ
	public static void setAutoCommit() throws SQLException {
		getConnection().setAutoCommit(false);
	}
	//��������,�ύ����
	public static void Commit() throws SQLException{
		getConnection().commit();
	}
	//��������,�ع�����
	public static void Rollback() throws SQLException{
		getConnection().rollback();
	}
	//��������,�ͷ���Դ
    public static void relase(){
    	try {
			getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    		
    }

}
