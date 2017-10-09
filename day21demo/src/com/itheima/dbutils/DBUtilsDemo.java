package com.itheima.dbutils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.c3p0utils.C3P0Utils;

/*
 *     DBUtils工具类的三个核心类
 *     DBUtils工具类,负责数据的增删改查,不负责创建,删除表,库等操作
 *        DBUtils类: 数据库操作对象的关闭功能,(事务处理)
 *        QueryRunner类: 执行SQL语句的类
 *           update()方法,执行数据库insert ,update ,delete
 *           query()方法,执行select
 *        ResultSetHandler接口: 查询后的结果集
 *          接口的实现类,都是结果集的处理方法
 *          9个实现类,9种不同的结果集方式
 *          
 *      QueryRunner类使用方式
 *         构造方法:
 *           QueryRunner() 无参构造
 *           QueryRunner(DataSource dataSource) 传递DataSource接口数据源
 *           
 *        int update()方法执行insert update delete
 *           update(Connection conn,String sql,Object... parms)
 *            conn : 数据库连接对象
 *            sql : 执行的SQL语句
 *            params: Object类型的可变参数,SQL中的问好占位符 
 *           update(String sql,Object...params)
 *             sql: 执行SQL语句
 *             params: Object类型的可变参数,SQL中的问号占位符
 *          使用此方法,不逊要传递连接对象,需要在构造方法中,传递DataSource接口的实现类
 */
public class DBUtilsDemo {
	public static void main(String[] args) throws SQLException {
		update();
//		insert();

	}

	/*
	 * QueryRunner类的方法update 修改表中的数据 创建QueryRunner类对象的时候,使用有参数的构造
	 * QueryRunner(DataSource dataSource) 传递DataSource接口的实现类
	 * 
	 */
	public static void update() throws SQLException {
		// 创建QueryRunner对象,构造方法传递DataSource接口实现类
		// 实现类,由C3P0Utils工具类方法getDataSource提供
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "UPDATE product SET pname=?,price=?,flag=? WHERE pid=?";
		int row = runner.update(sql,"迪奥", 999, 1, 9);
		System.out.println(row);
	}

	/*
	 * QueryRunner类的方法update 数据表添加数据 创建QueryRunner对象,使用无参数构造
	 */
	public static void insert() throws SQLException {
		// 创建QueryRunner类的对象
		QueryRunner runner = new QueryRunner();
		// 调用方法update执行SQL
		// 数据库连接对象,SQL语句,问号占位符
		// 获取数据库连接对象,C3P0Utils工具类方法getConnection
		Connection conn = C3P0Utils.getConnection();
		String sql = "INSERT INTO product(pname,price,flag)VALUES(?,?,?)";
		int row = runner.update(conn, sql, "小红书", 399, 1);
		System.out.println(row);
		C3P0Utils.relase(null, null, conn);
	}

}
