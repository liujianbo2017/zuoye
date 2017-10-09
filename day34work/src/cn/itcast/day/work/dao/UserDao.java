package cn.itcast.day.work.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.day.work.domain.User;
import cn.itcast.day.work.utils.JdbcUtils;

public class UserDao {
	public User findByUserName(String username) throws Exception{
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select *　from tb_user where username=?";
		User user = runner.query(sql, new BeanHandler<User>(User.class),username);
		return user;
	}

}
