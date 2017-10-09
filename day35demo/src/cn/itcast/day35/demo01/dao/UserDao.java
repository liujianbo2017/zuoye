package cn.itcast.day35.demo01.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.day35.demo01.domain.User;
import cn.itcast.day35.demo01.utils.JdbcUtils;

public class UserDao {
	public User findByUsername(String username) throws SQLException{
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from tb_user where username=?";
		User user = runner.query(sql, new BeanHandler<User>(User.class),username);
		return user;
	}

}
