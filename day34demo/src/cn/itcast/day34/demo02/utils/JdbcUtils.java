package cn.itcast.day34.demo02.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	//创建连接池对象
	private static DataSource dataSource = new ComboPooledDataSource();
	
	//获取连接池
	public static DataSource getDataSource(){
		return dataSource;
	}
	////在数据库工具类中添加一个用于保存连接对象(Connection)的ThreadLocal集合
	public static ThreadLocal<Connection> local = new ThreadLocal<Connection>();
	/**
	 * 从ThreadLocal取得连接对象，
	 * 如果取不到说明是当前线程第一次访问ThreadLocal，
	 * 此时，ThreadLocal集合中还没有此线程对应的Connection对象
	 * 所以从连接池中取得一个新的连接对象，并保存到ThreadLocal中
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		local.get();//因为ThreadLocal用当前线程做Key，所以取得值时不需要提供Key（Thread.currentThread()）
		if(conn==null){
			//如果是第一次取得，则当前线程在ThreadLocal中没有对应的Connection对象
			//从池中取得一个新的连接对象返回并保存到ThreadLocal
			try {
				conn=dataSource.getConnection();
				local.set(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return conn;

	}
}
