package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.ProductDao;
import com.itheima.domain.Products;
import com.itheima.utils.ConnectionManager;

public class ProductService {
	// 成员变量,创建dao层对象
	private static ProductDao dao = new ProductDao();

	// 实际开发中的删除
	public void deleteAll2(List<Integer> list) {
		try {
			dao.delete2(list);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除数据失败");
		}
	}

	/*
	 * 方法deleteAll(接收集合) 被Web层调用,传递集合 遍历集合,调用dao层delete方法 循环遍历集合,删除语句SQL,会执行多次
	 * 前几次成功,后面的失败 (全成功,全失败)
	 */
	public void deleteAll(List<Integer> list) {
		try {
			ConnectionManager.setAutoCommit();
			for (Integer i : list) {
				dao.delete(i);
			}
			ConnectionManager.commit();
		} catch (SQLException ex) {
			ConnectionManager.rollback();
		} finally {
			ConnectionManager.relase();
		}
	}

	/*
	 * 方法delete(int pid) 删除商品方法,被web层调用,传递用户输入的id值 调用dao层方法delete
	 */
	public void delete(int pid) {
		try {
			dao.delete(pid);
		} catch (SQLException e) {
			throw new RuntimeException("删除数据失败");
		}
	}

	/*
	 * 方法editProduct(Products p) 修改商品方法,被web调用,传递封装到的Products对象 调用dao层方法update
	 */
	public void editProducts(Products p) {
		try {
			dao.update(p);
		} catch (SQLException e) {
			throw new RuntimeException("修改数据失败");
		}
	}

	/*
	 * 方法addProduct(Products p) 添加商品方法,被web调用,传递封装到的Products对象 调用dao层方法save
	 */
	@SuppressWarnings("static-access")
	public void addProducts(Products p) {
		try {
			dao.addProducts(p);
		} catch (SQLException e) {
			throw new RuntimeException("添加失败");
		}
	}

	/*
	 * 方法findById(int pid)通过Id查询商品信息 调用dao层方法,返回list集合,存储在JavaBeab中
	 * 被web调用,传入用户输入的id
	 */
	public List<Products> findById(int pid) {
		try {
			return dao.findById(pid);
		} catch (SQLException e) {
			throw new RuntimeException("查询数据失败");
		}
	}

	/*
	 * 定义方法findAll查询所有数据 调用dao层方法,返回list集合,存储在JavaBean中 结果集返回web
	 */
	public List<Products> findAll() {
		try {
			return dao.findAll();
		} catch (SQLException e) {

			throw new RuntimeException("查询数据失败");
		}
	}

}
