package cn.itcast.day41.demo08.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	private static DataSource dataSource = new ComboPooledDataSource();
	public static DataSource getDataSource(){
		return dataSource;
	}
	private static ThreadLocal<Connection> local = new ThreadLocal<Connection>();
	public static Connection getConnection(){
		Connection conn = null;
		local.get();
		if(conn==null){
			try {
				conn = dataSource.getConnection();
				local.set(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}

}
