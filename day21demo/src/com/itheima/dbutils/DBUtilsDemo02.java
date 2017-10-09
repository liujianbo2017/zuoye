package com.itheima.dbutils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.bean.Product;
import com.itheima.c3p0utils.C3P0Utils;

/*
 *   QueryRunner类的方法query
 *   实现数据查询
 *       query(Connection conn,String sql,ResultSetHandler<T>rsh,Object...params)
 *        conn: 传递数据库连接
 *        sql: 传递执行SQL语句
 *        rsh: 传递ResultSetHandler接口实现类,不同结构集处理
 *        params: 传递问号占位符
 *        
 *     query(String sql,ResultSetHandler<T>rsh,Object..,params)
 * 
 */
public class DBUtilsDemo02 {
	public static void main(String[] args) throws SQLException {
		beanListHandler();

	}
	/*
	 * 结果集处理方式九
	 * 实现类KeyedHandler
	 * 查询数据表的每个数据,存储Map集合
	 * 多个Map,存储到另一个Map
	 * 外面Map,键 数据表的一个列名
	 */
	public static void keyedHandler() throws SQLException{
		 QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		//调用方法query查询数据,传递结果集处理对象MapListHandler
		 Map<Object,Map<String,Object>> map = runner.query("SELECT * FROM product", new KeyedHandler<Object>());
		 for(Object obj : map.keySet()){
			  Map<String,Object> value = map.get(obj);
			  System.out.println(value);
		 }
		 
	}
	/*
	 * 
	 * 结果集处理方式八
	 * 实现类MapListHandler
	 * 结果集每一行数据,存储到Map集合
	 * 多个Map集合存储到List集合
	 */ 
	 public static void mapListHandler() throws SQLException{
		 QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		//调用方法query查询数据,传递结果集处理对象MapListHandler
		 List<Map<String,Object>> list = runner.query("SELECT * FROM product", new MapListHandler());
		 for(Map<String,Object> map :list){
			 System.out.println(map);
		 }
	 }

	/*
	 * 结果集处理方式七 实现类MapHandler 查询数据表第一行数据,存储到Map集合
	 *  键: 列名 String 值 :列值 Object
	 * 返回的集合是LinkedHashMap的子类
	 */
	public static void mapHandler() throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		//调用方法query查询数据,传递结果集处理对象MapHandler
		Map<String,Object> map = runner.query("SELECT * FROM product", new MapHandler());
		System.out.println(map);
	}

	/*
	 * 处理结果集六 实现类ScalarHandler 适合单值查询,聚合函数
	 */
	public static void scalarHandler() throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		// 调用方法query查询数据,传递结果集处理对象ScalarHandler
		Object obj = runner.query("SELECT COUNT(*)AS c FROM product", new ScalarHandler<Object>("c"));
		System.out.println(obj);
	}

	/*
	 * 结果集处理方式五 实现类ColumnListHandler 结果集的指定类值存储到List<Object>集合
	 * ColumnListHandler(String columnName)构造方法,传递字符串列名
	 */
	public static void columListHandler() throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		// 调用方法query查询数据,传递结果集处理对象ColnmListHandler
		List<Object> list = runner.query("SELECT * FROM product", new ColumnListHandler<Object>("pname"));
		for (Object obj : list) {
			System.out.println(obj);
		}
	}

	/*
	 * 处理结果集方式四 实现类BeanListHandler 查询数据的每一行,存储在集合List 多个JavaBean对象,存储到集合List
	 * BeanListHandler(Class<T> type)传递JavaBean类的class文件对象
	 */
	public static void beanListHandler() throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		// 调用方法query查询数据,传递结果集处理对象BeanListHandler
		List<Product> list = runner.query("SELECT * FROM product", new BeanListHandler<Product>(Product.class));
		for (Product p : list) {
			System.out.println(p);
		}
	}

	/*
	 * 结果集处理方式三 实现类BeanHandler 查询数据表第一行,存储JavaBean对象
	 * BeanHandler(Class<T>type)构造方法,传递Class<T>type 传递JavaBean类的class文件对象
	 */
	public static void beanHandler() throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		// 调用query方法查询数据表,传递的结果集处理对象是BeanHandler
		Product p = runner.query("SELECT * FROM product", new BeanHandler<Product>(Product.class));
		System.out.println(p);

	}

	/*
	 * 结果集方式二 实现类ArrayListHandler 查询数据表的每行数据存储到Object[] 多行数据,出现多个Object,数组存储集合中
	 */
	public static void arrayListHandler() throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		// 调用方法query,查询数据表,传递结果集对象ArrayListHandler
		List<Object[]> list = runner.query("SELECT * FROM product", new ArrayListHandler());
		for (Object[] obj : list) {
			for (Object o : obj) {
				System.out.println(o);
			}
		}
	}

	/*
	 * 结果集处理方式一 实现类ArrayHandler 数据查询后的第一行,存储到对象数组Object[]
	 */
	public static void arrayhandler() throws SQLException {
		// 创建QueryRunner对象,构造方法中,传递数据源接口实现类
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		// 查询数据表,传递ArrayHandle
		Object[] obj = runner.query("SELECT * FROM product", new ArrayHandler());
		for (Object o : obj) {
			System.out.println(o + "\t");
		}
	}

}
