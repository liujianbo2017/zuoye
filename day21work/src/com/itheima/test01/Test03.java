package com.itheima.test01;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//�Զ���C3P0�����࣬Ҫ�����£�
//1.����˽�о�̬����Դ(���ӳض���)��Ա����
//2.�������еĵõ�����Դ(���ӳض���)�ķ���
//3.�������еĵõ����Ӷ���ķ���

public class Test03 {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
		throw new RuntimeException("���ݿ�����ʧ��");
		}
	}

	public static DataSource dataSource() {
		return dataSource;
	}

}
