package com.itheima.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import com.itheima.domain.User;
import com.itheima.utils.DataSourceUtils;

public class UserDao {
	public User findByUsernama(String username) throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=?";
		User user = runner.query(sql, new BeanHandler<User>(User.class),username);
		return user;
	}

}
