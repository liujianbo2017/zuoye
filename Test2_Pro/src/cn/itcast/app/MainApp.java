package cn.itcast.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.tools.JDBCUtils;

//b). 判断转出方是否有足够余额，如果不足，提示信息：”余额不足！”，并结
//
//束程序；
//
//c). 实现卡号：6212999999999向6212888888888转账600万的操作；
//
//      并将转入、转出记录分别写入到Transaction表中。
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
		// 设置变量
		double tranMoney = 6000000;
		// 查询转出账户是否有足够余额
		String sql = "SELECT balance FROM account WHERE cardid = '6212999999999'";
		Double balance;
		try {
			balance = (Double) runner.query(conn, sql, new ScalarHandler());
			if (balance < tranMoney) {
				System.out.println("转出方余额不足：" + tranMoney + " 万元");
				conn.setAutoCommit(true);
			}
			// 处理转出账户
			sql = "update account set balance = balance - " + tranMoney + " where cardid = '6212999999999'";
			runner.update(conn, sql);
			// 处理利率
			sql = "select balance from account where cardid = '6212999999999'";
			balance = (Double) runner.query(conn, sql, new ScalarHandler());
			if (balance < 15000000) {
				sql = "update account set moneyrate = 2.5 where cardid = '6212999999999'";
				runner.update(conn, sql);
			}
			// 处理转入账户
			sql = "update account set balance = balance + " + tranMoney + " where cardid = '6212888888888'";
			runner.update(conn, sql);
			// 处理利率
			if (balance >= 15000000) {
				sql = "update account set moneyrate = 2.8 where cardid = '6212888888888'";
				runner.update(conn, sql);
			}
			// 处理交易记录
			String datestr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			sql = "insert into transaction values(null,'6212999999999','转出'," + tranMoney + ",'" + datestr + "')";
			runner.update(conn, sql);
			sql = "insert into transaction values(null,'6212888888888','转入'," + tranMoney + ",'" + datestr + "')";
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

		System.out.println("转账完毕！");
	}
}
