package com.itheima.test01;
//使用Properties类加载属性文件

//2) 通过类对象的getResourceAsStream("/dbcp.properties")方法，从类路径下加载文件，以字节流的方式加载。
//3) 通过properties.load(InputStream in) 加载属性文件
//4) 通过BasicDataSourceFactory.createDataSource(Properties prop)，得到DataSource连接池对象
//5) 通过BasicDataSource类得到连接对象

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
