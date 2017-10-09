package com.itheima.test01;
//ʹ��DBCP���ӳػ��10�����Ӷ���Ҫ�����£�
//1.�������д������Ϣ(��ʹ�������ļ�)
//2.���ó�ʼΪ5�������10�������ȴ�ʱ��3�룬�����и���3��

import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Test04 {
	public static void main(String[] args) throws Exception {
		// ������ӳض���
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		// �������Ӳ���jdbcUrl��user��password��driverClass
		// �������ݿ���URL
		dataSource.setJdbcUrl("jdbc:mysql://loaclhose:3306/day21");
		// ������������
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		// ��������
		dataSource.setUser("root");
		// �����û���
		dataSource.setPassword("root");
		// ���ó�ʼ������initialPoolSize
		dataSource.setInitialPoolSize(5);
		// ���������maxPoolSize
		dataSource.setMaxPoolSize(10);
		// ���ȴ�ʱ��checkoutTimeout
		dataSource.setCheckoutTimeout(3);
		// �����л���ʱ��maxIdleTime
		dataSource.setMaxIdleTime(3);
		// ��ȡ���Ӷ���getConnection() ������
		for (int i = 0; i < 10; i++) {
			Connection conn = dataSource.getConnection();
			System.out.println("��" + (i + 1) + "��:" + conn);
		}

	}

}

