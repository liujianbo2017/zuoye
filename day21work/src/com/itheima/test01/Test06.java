package com.itheima.test01;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

//�Զ���DBCP�����࣬Ҫ�����£�
//1)	������̬���ӶԳس�Ա����
//2)	��д��̬���飺������·���µ������ļ�������ʹ�ù����ഴ������Դ(���ӳض���)
//3)	��д����������̬��������������Դ(���ӳض���)�ͷ������Ӷ���
//4)	��д��������Ըù��������ط�����

public class Test06 {
	private static DataSource dataSource;
	static {
		try {
			InputStream is = Test06.class.getClassLoader().getResourceAsStream("database.properties");
			Properties p = new Properties();
			p.load(is);
			dataSource = BasicDataSourceFactory.createDataSource(p);
		} catch (Exception ex) {
			throw new RuntimeException("�ļ���ȡʧ��");
		}
	}

	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("���ݿ�����ʧ��");
		}
	}

}
