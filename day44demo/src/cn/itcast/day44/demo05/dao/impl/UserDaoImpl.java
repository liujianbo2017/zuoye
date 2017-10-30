package cn.itcast.day44.demo05.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.day44.demo05.dao.UserDao;
import cn.itcast.day44.demo05.domain.User;
import cn.itcast.day44.demo05.utils.JdbcUtils;

public class UserDaoImpl implements UserDao {

	//根据用户名取得用户对象
	@Override
	public User findByUsername(String username) throws Exception {
		
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		
		String sql = "select *　from tb_user where username=?";
		
		User user = runner.query(sql, new BeanHandler<User>(User.class),username);
		return user;
	}

}
