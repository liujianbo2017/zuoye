package com.itheima.c3p0utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 *   C3P0连接池,工具类
 *   返回数据库链接
 *   javax.sql.DataSource接口实现类
 *   c3p0类库中,ComboPooledDataSource接口实现咧
 *   ComboPooledDataSource方法setXXX 配置数据库的四大信息
 *   
 *   C3P0配置文件中,XML配置,创建文件从c3p0-config.xml
 *   存储在src中会自动读取xml文件
 */
public class C3P0Utils {
	//创建出ComboPooledDataSource对象
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	/*static{
		try{
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/day21");
			dataSource.setUser("root");
			dataSource.setPassword("root");
		}catch(Exception ex){
			throw new RuntimeException("数据库连接失败");
		}
	}*/
	public static Connection getConnection(){
		try{
			return dataSource.getConnection();
		}catch(Exception ex){
			throw new RuntimeException("数据库连接失败");
		}
	}
	//静态方法,返回DataSource接口的实现类ComboPooledDataSource对象
	public static DataSource getDataSource(){
		return dataSource;
	}
	/*
	 *  释放资源的方法
	 *  连接对象的方法close(),真的连接没有断开
	 *  连接对象,交回连接池 
	 */
	public static void relase(ResultSet rs, Statement stat, Connection conn){
		if(rs!=null)
			try{
				rs.close();
			}catch(Exception ex){
			}
		if(stat!=null)
			try{
				stat.close();
			}catch(Exception ex){
			}
		if(conn!=null)
			try{
				conn.close();
			}catch(Exception ex){
			}
	}

}
