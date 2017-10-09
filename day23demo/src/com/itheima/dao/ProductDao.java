package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.domain.Products;
import com.itheima.utils.C3P0Utils;
import com.itheima.utils.ConnectionManager;

public class ProductDao {
	// 实际开发中的删除
	public void delete2(List<Integer> list) throws SQLException {
		// QueryRunner对象,构造方法,直接获取数据源
		QueryRunner runner = new QueryRunner(C3P0Utils.dataSource());
		//拼写删除语句SQL
		//动态拼接SQL语句
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM products WHERE in(");
		for (int i = 0; i < list.size(); i++) {
			if(i!=list.size()-1){
				sb.append("?,");
			}else{
				sb.append("?");
			}
		}
		runner.update(sb.toString(),list.toArray());
	}

	/*
	 * 方法delete,商品的id删除 被service调用,传递是用户输入的id
	 */
	public void delete(int pid) throws SQLException {
		// QueryRunner对象,构造方法,直接获取数据源
		QueryRunner runner = new QueryRunner(C3P0Utils.dataSource());
		// 拼写查询语句SQL
		String sql = "DELETE FROM products WHERE pid=?";
		runner.update(ConnectionManager.getConnection(), sql, pid);
	}

	/*
	 * 方法update,商品数据进行修改 被service调用,传递Products对象 没有返回值
	 */
	public void update(Products p) throws SQLException {
		// QueryRunner对象,构造方法,直接获取数据源
		QueryRunner runner = new QueryRunner(C3P0Utils.dataSource());
		// 拼写查询语句SQL
		String sql = "UPDATE products SET pname=?,price=?,flag=?,category_id=? WHERE pid=?";
		runner.update(sql, p.getPname(), p.getPrice(), p.getFlag(), p.getCategory_id(), p.getPid());
	}

	/*
	 * 方法addProducts()添加商品信息
	 */
	public void addProducts(Products p) throws SQLException {
		// QueryRunner对象,构造方法,直接获取数据源
		QueryRunner runner = new QueryRunner(C3P0Utils.dataSource());
		// 拼写查询语句SQL
		String sql = "INSERT INTO products (pname,price,flag,category_id)VALUES(?,?,?,?)";
		// 执行update方法.传递实际参数,来自products对象
		runner.update(sql, p.getPname(), p.getPrice(), p.getFlag(), p.getCategory_id());
	}

	/*
	 * 方法findById()根据id查询数据 被业务层调用,返回查询的结果集 结果集处理方式BeanListHandler
	 */
	public List<Products> findById(int pid) throws SQLException {
		// QueryRunner对象,构造方法,直接获取数据源
		QueryRunner runner = new QueryRunner(C3P0Utils.dataSource());
		// 拼写查询语句SQL
		String sql = "SELECT * FROM products WHERE pid=?";
		return runner.query(sql, new BeanListHandler<Products>(Products.class), pid);
	}

	/*
	 * 方法 findAll()查询数据表的所有数据 被业务层方法调用,返回查询的结果集 结果集处理方式 BeanListHandler
	 */
	public List<Products> findAll() throws SQLException {
		// QueryRunner对象,构造方法,直接获取数据源
		QueryRunner runner = new QueryRunner(C3P0Utils.dataSource());
		// 拼写查询所有数据的SQL
		String sql = "SELECT * FROM products";
		// 执行查询query
		return runner.query(sql, new BeanListHandler<Products>(Products.class));

	}

}
