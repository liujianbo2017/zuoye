package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 *   JDBC����,ʵ��ģ��ת�˲���
 *     ����update���,����һ��ִ��,���ɹ�,���߶�ʧ��
 *     ���ݿ�: ���SQL�������һ��,������ͬһ��Connection����ִ��
 *     �˻���,ԭ��ƽ̨ת�˵�����  1000
 *     
 *   ʹ������,��֤��ȫ��,
 *     ��������
 *     ����û���κ�����,�ύ����,���ݳ־�
 *     �����������,�ع�����,�����˻ص�ԭʼ״̬
 *     
 *   Connection�ӿڶ����������������񷽷�
 *      setAutoCommit(false)��ֹ�����Զ��ύ
 *      commit() �ύ����
 *      rollback() �ع�����
 *      
 *   SQL���ִ�в���֮ǰ,��������
 *   SQL���ִ����Ϻ�,������,�ύ����(�����쳣)
 *   SQL���ִ�г�������,�ع�����(�׳��쳣)
 * 
 */
public class JDBCDemo {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day22", "root", "root");
			conn.setAutoCommit(false);
			stat = conn.createStatement();
			String sql = "UPDATE account SET menoy=menoy+1000 WHERE aname='����'";
			String sql2 = "UPDATE account SET menoy=menoy-1000 WHERE aname='ԭ��ƽ̨'";
			int row = stat.executeUpdate(sql);
			int row2 = stat.executeUpdate(sql2);
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
		} finally {
			if (stat != null)
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

}
