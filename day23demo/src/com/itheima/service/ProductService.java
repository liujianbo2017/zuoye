package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.ProductDao;
import com.itheima.domain.Products;
import com.itheima.utils.ConnectionManager;

public class ProductService {
	// ��Ա����,����dao�����
	private static ProductDao dao = new ProductDao();

	// ʵ�ʿ����е�ɾ��
	public void deleteAll2(List<Integer> list) {
		try {
			dao.delete2(list);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("ɾ������ʧ��");
		}
	}

	/*
	 * ����deleteAll(���ռ���) ��Web�����,���ݼ��� ��������,����dao��delete���� ѭ����������,ɾ�����SQL,��ִ�ж��
	 * ǰ���γɹ�,�����ʧ�� (ȫ�ɹ�,ȫʧ��)
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
	 * ����delete(int pid) ɾ����Ʒ����,��web�����,�����û������idֵ ����dao�㷽��delete
	 */
	public void delete(int pid) {
		try {
			dao.delete(pid);
		} catch (SQLException e) {
			throw new RuntimeException("ɾ������ʧ��");
		}
	}

	/*
	 * ����editProduct(Products p) �޸���Ʒ����,��web����,���ݷ�װ����Products���� ����dao�㷽��update
	 */
	public void editProducts(Products p) {
		try {
			dao.update(p);
		} catch (SQLException e) {
			throw new RuntimeException("�޸�����ʧ��");
		}
	}

	/*
	 * ����addProduct(Products p) �����Ʒ����,��web����,���ݷ�װ����Products���� ����dao�㷽��save
	 */
	@SuppressWarnings("static-access")
	public void addProducts(Products p) {
		try {
			dao.addProducts(p);
		} catch (SQLException e) {
			throw new RuntimeException("���ʧ��");
		}
	}

	/*
	 * ����findById(int pid)ͨ��Id��ѯ��Ʒ��Ϣ ����dao�㷽��,����list����,�洢��JavaBeab��
	 * ��web����,�����û������id
	 */
	public List<Products> findById(int pid) {
		try {
			return dao.findById(pid);
		} catch (SQLException e) {
			throw new RuntimeException("��ѯ����ʧ��");
		}
	}

	/*
	 * ���巽��findAll��ѯ�������� ����dao�㷽��,����list����,�洢��JavaBean�� ���������web
	 */
	public List<Products> findAll() {
		try {
			return dao.findAll();
		} catch (SQLException e) {

			throw new RuntimeException("��ѯ����ʧ��");
		}
	}

}
