package com.itheima.dbutils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.c3p0utils.C3P0Utils;

/*
 *     DBUtils�����������������
 *     DBUtils������,�������ݵ���ɾ�Ĳ�,�����𴴽�,ɾ����,��Ȳ���
 *        DBUtils��: ���ݿ��������Ĺرչ���,(������)
 *        QueryRunner��: ִ��SQL������
 *           update()����,ִ�����ݿ�insert ,update ,delete
 *           query()����,ִ��select
 *        ResultSetHandler�ӿ�: ��ѯ��Ľ����
 *          �ӿڵ�ʵ����,���ǽ�����Ĵ�����
 *          9��ʵ����,9�ֲ�ͬ�Ľ������ʽ
 *          
 *      QueryRunner��ʹ�÷�ʽ
 *         ���췽��:
 *           QueryRunner() �޲ι���
 *           QueryRunner(DataSource dataSource) ����DataSource�ӿ�����Դ
 *           
 *        int update()����ִ��insert update delete
 *           update(Connection conn,String sql,Object... parms)
 *            conn : ���ݿ����Ӷ���
 *            sql : ִ�е�SQL���
 *            params: Object���͵Ŀɱ����,SQL�е��ʺ�ռλ�� 
 *           update(String sql,Object...params)
 *             sql: ִ��SQL���
 *             params: Object���͵Ŀɱ����,SQL�е��ʺ�ռλ��
 *          ʹ�ô˷���,��ѷҪ�������Ӷ���,��Ҫ�ڹ��췽����,����DataSource�ӿڵ�ʵ����
 */
public class DBUtilsDemo {
	public static void main(String[] args) throws SQLException {
		update();
//		insert();

	}

	/*
	 * QueryRunner��ķ���update �޸ı��е����� ����QueryRunner������ʱ��,ʹ���в����Ĺ���
	 * QueryRunner(DataSource dataSource) ����DataSource�ӿڵ�ʵ����
	 * 
	 */
	public static void update() throws SQLException {
		// ����QueryRunner����,���췽������DataSource�ӿ�ʵ����
		// ʵ����,��C3P0Utils�����෽��getDataSource�ṩ
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "UPDATE product SET pname=?,price=?,flag=? WHERE pid=?";
		int row = runner.update(sql,"�ϰ�", 999, 1, 9);
		System.out.println(row);
	}

	/*
	 * QueryRunner��ķ���update ���ݱ�������� ����QueryRunner����,ʹ���޲�������
	 */
	public static void insert() throws SQLException {
		// ����QueryRunner��Ķ���
		QueryRunner runner = new QueryRunner();
		// ���÷���updateִ��SQL
		// ���ݿ����Ӷ���,SQL���,�ʺ�ռλ��
		// ��ȡ���ݿ����Ӷ���,C3P0Utils�����෽��getConnection
		Connection conn = C3P0Utils.getConnection();
		String sql = "INSERT INTO product(pname,price,flag)VALUES(?,?,?)";
		int row = runner.update(conn, sql, "С����", 399, 1);
		System.out.println(row);
		C3P0Utils.relase(null, null, conn);
	}

}
