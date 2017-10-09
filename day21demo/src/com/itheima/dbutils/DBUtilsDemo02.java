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
 *   QueryRunner��ķ���query
 *   ʵ�����ݲ�ѯ
 *       query(Connection conn,String sql,ResultSetHandler<T>rsh,Object...params)
 *        conn: �������ݿ�����
 *        sql: ����ִ��SQL���
 *        rsh: ����ResultSetHandler�ӿ�ʵ����,��ͬ�ṹ������
 *        params: �����ʺ�ռλ��
 *        
 *     query(String sql,ResultSetHandler<T>rsh,Object..,params)
 * 
 */
public class DBUtilsDemo02 {
	public static void main(String[] args) throws SQLException {
		beanListHandler();

	}
	/*
	 * ���������ʽ��
	 * ʵ����KeyedHandler
	 * ��ѯ���ݱ��ÿ������,�洢Map����
	 * ���Map,�洢����һ��Map
	 * ����Map,�� ���ݱ��һ������
	 */
	public static void keyedHandler() throws SQLException{
		 QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		//���÷���query��ѯ����,���ݽ�����������MapListHandler
		 Map<Object,Map<String,Object>> map = runner.query("SELECT * FROM product", new KeyedHandler<Object>());
		 for(Object obj : map.keySet()){
			  Map<String,Object> value = map.get(obj);
			  System.out.println(value);
		 }
		 
	}
	/*
	 * 
	 * ���������ʽ��
	 * ʵ����MapListHandler
	 * �����ÿһ������,�洢��Map����
	 * ���Map���ϴ洢��List����
	 */ 
	 public static void mapListHandler() throws SQLException{
		 QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		//���÷���query��ѯ����,���ݽ�����������MapListHandler
		 List<Map<String,Object>> list = runner.query("SELECT * FROM product", new MapListHandler());
		 for(Map<String,Object> map :list){
			 System.out.println(map);
		 }
	 }

	/*
	 * ���������ʽ�� ʵ����MapHandler ��ѯ���ݱ��һ������,�洢��Map����
	 *  ��: ���� String ֵ :��ֵ Object
	 * ���صļ�����LinkedHashMap������
	 */
	public static void mapHandler() throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		//���÷���query��ѯ����,���ݽ�����������MapHandler
		Map<String,Object> map = runner.query("SELECT * FROM product", new MapHandler());
		System.out.println(map);
	}

	/*
	 * ���������� ʵ����ScalarHandler �ʺϵ�ֵ��ѯ,�ۺϺ���
	 */
	public static void scalarHandler() throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		// ���÷���query��ѯ����,���ݽ�����������ScalarHandler
		Object obj = runner.query("SELECT COUNT(*)AS c FROM product", new ScalarHandler<Object>("c"));
		System.out.println(obj);
	}

	/*
	 * ���������ʽ�� ʵ����ColumnListHandler �������ָ����ֵ�洢��List<Object>����
	 * ColumnListHandler(String columnName)���췽��,�����ַ�������
	 */
	public static void columListHandler() throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		// ���÷���query��ѯ����,���ݽ�����������ColnmListHandler
		List<Object> list = runner.query("SELECT * FROM product", new ColumnListHandler<Object>("pname"));
		for (Object obj : list) {
			System.out.println(obj);
		}
	}

	/*
	 * ����������ʽ�� ʵ����BeanListHandler ��ѯ���ݵ�ÿһ��,�洢�ڼ���List ���JavaBean����,�洢������List
	 * BeanListHandler(Class<T> type)����JavaBean���class�ļ�����
	 */
	public static void beanListHandler() throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		// ���÷���query��ѯ����,���ݽ�����������BeanListHandler
		List<Product> list = runner.query("SELECT * FROM product", new BeanListHandler<Product>(Product.class));
		for (Product p : list) {
			System.out.println(p);
		}
	}

	/*
	 * ���������ʽ�� ʵ����BeanHandler ��ѯ���ݱ��һ��,�洢JavaBean����
	 * BeanHandler(Class<T>type)���췽��,����Class<T>type ����JavaBean���class�ļ�����
	 */
	public static void beanHandler() throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		// ����query������ѯ���ݱ�,���ݵĽ�������������BeanHandler
		Product p = runner.query("SELECT * FROM product", new BeanHandler<Product>(Product.class));
		System.out.println(p);

	}

	/*
	 * �������ʽ�� ʵ����ArrayListHandler ��ѯ���ݱ��ÿ�����ݴ洢��Object[] ��������,���ֶ��Object,����洢������
	 */
	public static void arrayListHandler() throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		// ���÷���query,��ѯ���ݱ�,���ݽ��������ArrayListHandler
		List<Object[]> list = runner.query("SELECT * FROM product", new ArrayListHandler());
		for (Object[] obj : list) {
			for (Object o : obj) {
				System.out.println(o);
			}
		}
	}

	/*
	 * ���������ʽһ ʵ����ArrayHandler ���ݲ�ѯ��ĵ�һ��,�洢����������Object[]
	 */
	public static void arrayhandler() throws SQLException {
		// ����QueryRunner����,���췽����,��������Դ�ӿ�ʵ����
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		// ��ѯ���ݱ�,����ArrayHandle
		Object[] obj = runner.query("SELECT * FROM product", new ArrayHandler());
		for (Object o : obj) {
			System.out.println(o + "\t");
		}
	}

}
