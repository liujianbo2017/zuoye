package com.itheima.c3p0utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 *  C3P0���ӳ�,������
 *  �������ݿ�����
 *  javax.sql.DataSource�ӿ�ʵ����
 *  c3p0�����,ComboPooledDataSource�ӿ�ʵ����
 *  ComboPooledDataSource����setXXX �������ݿ���Ĵ���Ϣ
 *  
 *  C3P0�����ļ���,XML����,�����ļ�c3p0-config.xml
 *  �洢��src�� ���Զ���ȡxml�ļ�
 */
public class C3P0Utils {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (Exception ex) {
			throw new RuntimeException("���ݿ�����ʧ��");
		}
	}

	/*
	 * ��̬����,����DataSource�ӿ�ʵ����ComboPooledDataSource����
	 */
	public static DataSource dataSource() {
		return dataSource;
	}

	public static void relase(ResultSet rs, Statement stat, Connection conn) {
		if (rs != null)
			try {
				rs.close();
			} catch (Exception ex) {
			}
		if (stat != null)
			try {
				stat.close();
			} catch (Exception ex) {
			}
		if (conn != null)
			try {
				conn.close();
			} catch (Exception ex) {
			}
	}

}
