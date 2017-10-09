package com.itheima.test01;
//1.	�������ӳض���ComboPooledDataSource����

//2.	�������Ӳ�����jdbcUrl��user��password��driverClass��
//3.	�������ӳز���
//4.	��ʼ������initialPoolSize
//a)	���������maxPoolSize
//b)	���ȴ�ʱ��checkoutTimeout
//c)	�����л���ʱ��maxIdleTime
//5.	��ȡ���Ӷ���getConnection() ������

import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Test01 {
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
		dataSource.setMaxPoolSize(20);
		// ���ȴ�ʱ��checkoutTimeout
		dataSource.setCheckoutTimeout(3000);
		// �����л���ʱ��maxIdleTime
		dataSource.setMaxIdleTime(1000);
		// ��ȡ���Ӷ���getConnection() ������
		for (int i = 0; i < 10; i++) {
			Connection conn = dataSource.getConnection();
			System.out.println("��" + (i + 1) + "��:" + conn);
		}

	}

}
