package com.itheima.dbcptest;

import java.sql.Connection;

import com.itheima.c3p0utils.C3P0Utils;



/*
 *   ����DBCP���ӳصĹ�����
 *   ͨ����ľ�̬��������ȡ���� 
 */
public class DBCPTest {
	public static void main(String[] args) {
		Connection conn = C3P0Utils.getConnection();
		System.out.println(conn);
	}
	

}
