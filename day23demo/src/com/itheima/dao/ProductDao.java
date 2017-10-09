package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.domain.Products;
import com.itheima.utils.C3P0Utils;
import com.itheima.utils.ConnectionManager;

public class ProductDao {
	// ʵ�ʿ����е�ɾ��
	public void delete2(List<Integer> list) throws SQLException {
		// QueryRunner����,���췽��,ֱ�ӻ�ȡ����Դ
		QueryRunner runner = new QueryRunner(C3P0Utils.dataSource());
		//ƴдɾ�����SQL
		//��̬ƴ��SQL���
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
	 * ����delete,��Ʒ��idɾ�� ��service����,�������û������id
	 */
	public void delete(int pid) throws SQLException {
		// QueryRunner����,���췽��,ֱ�ӻ�ȡ����Դ
		QueryRunner runner = new QueryRunner(C3P0Utils.dataSource());
		// ƴд��ѯ���SQL
		String sql = "DELETE FROM products WHERE pid=?";
		runner.update(ConnectionManager.getConnection(), sql, pid);
	}

	/*
	 * ����update,��Ʒ���ݽ����޸� ��service����,����Products���� û�з���ֵ
	 */
	public void update(Products p) throws SQLException {
		// QueryRunner����,���췽��,ֱ�ӻ�ȡ����Դ
		QueryRunner runner = new QueryRunner(C3P0Utils.dataSource());
		// ƴд��ѯ���SQL
		String sql = "UPDATE products SET pname=?,price=?,flag=?,category_id=? WHERE pid=?";
		runner.update(sql, p.getPname(), p.getPrice(), p.getFlag(), p.getCategory_id(), p.getPid());
	}

	/*
	 * ����addProducts()�����Ʒ��Ϣ
	 */
	public void addProducts(Products p) throws SQLException {
		// QueryRunner����,���췽��,ֱ�ӻ�ȡ����Դ
		QueryRunner runner = new QueryRunner(C3P0Utils.dataSource());
		// ƴд��ѯ���SQL
		String sql = "INSERT INTO products (pname,price,flag,category_id)VALUES(?,?,?,?)";
		// ִ��update����.����ʵ�ʲ���,����products����
		runner.update(sql, p.getPname(), p.getPrice(), p.getFlag(), p.getCategory_id());
	}

	/*
	 * ����findById()����id��ѯ���� ��ҵ������,���ز�ѯ�Ľ���� ���������ʽBeanListHandler
	 */
	public List<Products> findById(int pid) throws SQLException {
		// QueryRunner����,���췽��,ֱ�ӻ�ȡ����Դ
		QueryRunner runner = new QueryRunner(C3P0Utils.dataSource());
		// ƴд��ѯ���SQL
		String sql = "SELECT * FROM products WHERE pid=?";
		return runner.query(sql, new BeanListHandler<Products>(Products.class), pid);
	}

	/*
	 * ���� findAll()��ѯ���ݱ���������� ��ҵ��㷽������,���ز�ѯ�Ľ���� ���������ʽ BeanListHandler
	 */
	public List<Products> findAll() throws SQLException {
		// QueryRunner����,���췽��,ֱ�ӻ�ȡ����Դ
		QueryRunner runner = new QueryRunner(C3P0Utils.dataSource());
		// ƴд��ѯ�������ݵ�SQL
		String sql = "SELECT * FROM products";
		// ִ�в�ѯquery
		return runner.query(sql, new BeanListHandler<Products>(Products.class));

	}

}
