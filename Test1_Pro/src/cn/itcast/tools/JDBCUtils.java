package cn.itcast.tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//˽�У���̬��Ա������ComboPooledDataSource ���������󣻼���������
//
//����Ĭ�����á�
//
//b). ���У���̬��Ա������public static DataSource getDataSource()���˷�����
//
//��C3P0���ӳض���
//
//c). ���У���̬��Ա������public static Connection getConnection()���˷�������
//
//ͨ��C3P0���ӳػ�ȡ��Connection����
public class JDBCUtils {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

	public static DataSource getDataSource() {
		return dataSource;
	}

	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("���ݿ�����ʧ��");
		}
	}

	public static void relase(ResultSet rs, Statement stat, Connection conn) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (stat != null)
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
