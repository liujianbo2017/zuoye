package com.itheima.dbcputils;

import java.sql.Connection;

import org.apache.commons.dbcp.BasicDataSource;

/*
 *   Apache数据库的连接池工具类:
 *       javax.sql.DataSource接口,数据库连接池对象必须实现接口
 *       重写方法 Connection getConnection
 *       
 *   Apache的DBCP连接池工具类,手动设置
 *   
 */
public class DBCPUtils {
	// 类的成员位置,创建出BacicDataSource对象
	private static BasicDataSource dataSource = new BasicDataSource();
	/*
	 * 静态方法,获取数据库的连接 Apache工具类DataSource接口实现类 BasicDataSource对象创建 数据库链接四大信息配置进去
	 * 方法名setXXX开头
	 */
	static {
		// 数据库连接四大信息
		// setDriverClassName(String driverClassName)设置数据库的驱动名
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		// setURL(String url)设置数据库的连接地址
		dataSource.setUrl("jdbc:mysql://localhost:3306/day21");
		// setUsername(String username)设置数据库登录用户名
		dataSource.setUsername("root");
		// setPassword(String password)
		dataSource.setPassword("root");
	}

	public static Connection getConnection() {
		try {
			// dataSource对象方法getConnection()
			Connection conn = dataSource.getConnection();
			return conn;
		} catch (Exception ex) {
			throw new RuntimeException("数据库连接失败");
		}
	}

}
