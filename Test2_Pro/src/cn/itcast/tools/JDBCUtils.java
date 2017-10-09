package cn.itcast.tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//私有，静态成员变量：ComboPooledDataSource 并创建对象；加载配置文
//
//件的默认配置。
//
//b). 公有，静态成员方法：public static DataSource getDataSource()，此方法返
//
//回C3P0连接池对象；
//
//c). 公有，静态成员方法：public static Connection getConnection()，此方法返回
//
//通过C3P0连接池获取的Connection对象；
public class JDBCUtils {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

	public static DataSource getDataSource() {
		return dataSource;
	}

	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("数据库连接失败");
		}
	}

	public static void relase(ResultSet rs, Statement stat, Connection conn) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (stat != null)
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
