package cn.itcast.day40.demo02.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.day40.demo02.dao.UserDao;
import cn.itcast.day40.demo02.domain.User;
import cn.itcast.day40.demo02.utils.JdbcUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public User findByUsername(String username) throws Exception {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from tb_user where username=?";
		User user = runner.query(sql, new BeanHandler<User>(User.class),username);
		System.out.println("user");
		return user;
	}

}
