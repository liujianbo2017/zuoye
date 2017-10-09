package com.itheima.dbcputils;

import java.sql.Connection;

import org.apache.commons.dbcp.BasicDataSource;

/*
 *   Apache���ݿ�����ӳع�����:
 *       javax.sql.DataSource�ӿ�,���ݿ����ӳض������ʵ�ֽӿ�
 *       ��д���� Connection getConnection
 *       
 *   Apache��DBCP���ӳع�����,�ֶ�����
 *   
 */
public class DBCPUtils {
	// ��ĳ�Աλ��,������BacicDataSource����
	private static BasicDataSource dataSource = new BasicDataSource();
	/*
	 * ��̬����,��ȡ���ݿ������ Apache������DataSource�ӿ�ʵ���� BasicDataSource���󴴽� ���ݿ������Ĵ���Ϣ���ý�ȥ
	 * ������setXXX��ͷ
	 */
	static {
		// ���ݿ������Ĵ���Ϣ
		// setDriverClassName(String driverClassName)�������ݿ��������
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		// setURL(String url)�������ݿ�����ӵ�ַ
		dataSource.setUrl("jdbc:mysql://localhost:3306/day21");
		// setUsername(String username)�������ݿ��¼�û���
		dataSource.setUsername("root");
		// setPassword(String password)
		dataSource.setPassword("root");
	}

	public static Connection getConnection() {
		try {
			// dataSource���󷽷�getConnection()
			Connection conn = dataSource.getConnection();
			return conn;
		} catch (Exception ex) {
			throw new RuntimeException("���ݿ�����ʧ��");
		}
	}

}
