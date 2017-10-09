package com.itheima.test01;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//ʹ��C3P0���ӳػ��10�����Ӷ���
//Ҫ�󣺷ֱ�ʹ��Ĭ�����ú��������ô������ӳض�����ͨ�����ӳض��������Ӷ���

public class Test02 {
	public static void main(String[] args) throws SQLException {
		test01();
	}
	// ʹ��Ĭ������(default-config)
	public static  void test01() throws SQLException{
		ComboPooledDataSource dataSource = new  ComboPooledDataSource();
		for (int i = 0; i < 10; i++) {
			Connection conn = dataSource.getConnection();
			System.out.println("��" + (i + 1) + "��:" + conn);
			if(i==3){
				conn.close();
			}
		}
	}
	//ʹ����������(named-config)
	public static void test01_2() throws SQLException{
		ComboPooledDataSource dataSource = new ComboPooledDataSource("named-config");
		for (int i = 0; i <10; i++) {
			Connection conn = dataSource.getConnection();
			System.out.println("��" + (i + 1) + "��:" + conn);
		}
	}

}
