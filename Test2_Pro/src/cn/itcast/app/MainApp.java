package cn.itcast.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.tools.JDBCUtils;

//b). �ж�ת�����Ƿ����㹻��������㣬��ʾ��Ϣ�������㣡��������
//
//������
//
//c). ʵ�ֿ��ţ�6212999999999��6212888888888ת��600��Ĳ�����
//
//      ����ת�롢ת����¼�ֱ�д�뵽Transaction���С�
public class MainApp {
	public static void main(String[] args) {
		QueryRunner runner = new QueryRunner();
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			conn.setAutoCommit(false);

		} catch (SQLException ex) {
			return;
		}
		// ���ñ���
		double tranMoney = 6000000;
		// ��ѯת���˻��Ƿ����㹻���
		String sql = "SELECT balance FROM account WHERE cardid = '6212999999999'";
		Double balance;
		try {
			balance = (Double) runner.query(conn, sql, new ScalarHandler());
			if (balance < tranMoney) {
				System.out.println("ת�������㣺" + tranMoney + " ��Ԫ");
				conn.setAutoCommit(true);
			}
			// ����ת���˻�
			sql = "update account set balance = balance - " + tranMoney + " where cardid = '6212999999999'";
			runner.update(conn, sql);
			// ��������
			sql = "select balance from account where cardid = '6212999999999'";
			balance = (Double) runner.query(conn, sql, new ScalarHandler());
			if (balance < 15000000) {
				sql = "update account set moneyrate = 2.5 where cardid = '6212999999999'";
				runner.update(conn, sql);
			}
			// ����ת���˻�
			sql = "update account set balance = balance + " + tranMoney + " where cardid = '6212888888888'";
			runner.update(conn, sql);
			// ��������
			if (balance >= 15000000) {
				sql = "update account set moneyrate = 2.8 where cardid = '6212888888888'";
				runner.update(conn, sql);
			}
			// �����׼�¼
			String datestr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			sql = "insert into transaction values(null,'6212999999999','ת��'," + tranMoney + ",'" + datestr + "')";
			runner.update(conn, sql);
			sql = "insert into transaction values(null,'6212888888888','ת��'," + tranMoney + ",'" + datestr + "')";
			runner.update(conn, sql);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {

			}
			return;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}

		}

		System.out.println("ת����ϣ�");
	}
}
