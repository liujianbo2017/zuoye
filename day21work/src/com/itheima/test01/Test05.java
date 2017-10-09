package com.itheima.test01;
//ʹ��Properties����������ļ�

//2) ͨ��������getResourceAsStream("/dbcp.properties")����������·���¼����ļ������ֽ����ķ�ʽ���ء�
//3) ͨ��properties.load(InputStream in) ���������ļ�
//4) ͨ��BasicDataSourceFactory.createDataSource(Properties prop)���õ�DataSource���ӳض���
//5) ͨ��BasicDataSource��õ����Ӷ���

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class Test05 {
	public static void main(String[] args) throws Exception {
		InputStream is = Test05.class.getClassLoader().getResourceAsStream("database.properties");
		Properties p = new Properties();
		p.load(is);
		BasicDataSource bs = (BasicDataSource) BasicDataSourceFactory.createDataSource(p);
		for (int i = 0; i < 10; i++) {
			Connection conn = bs.getConnection();
			System.out.println(conn.hashCode());
		}

	}

}
