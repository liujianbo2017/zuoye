package com.itheima.test01;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

//自定义DBCP工具类，要求如下：
//1)	声明静态连接对池成员变量
//2)	编写静态语句块：加载类路径下的属性文件，并且使用工厂类创建数据源(连接池对象)
//3)	编写两个公共静态方法，返回数据源(连接池对象)和返回连接对象。
//4)	编写测试类测试该工具类的相关方法。

public class Test06 {
	private static DataSource dataSource;
	static {
		try {
			InputStream is = Test06.class.getClassLoader().getResourceAsStream("database.properties");
			Properties p = new Properties();
			p.load(is);
			dataSource = BasicDataSourceFactory.createDataSource(p);
		} catch (Exception ex) {
			throw new RuntimeException("文件读取失败");
		}
	}

	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("数据库连接失败");
		}
	}

}
