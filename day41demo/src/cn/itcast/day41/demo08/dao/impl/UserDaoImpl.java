package cn.itcast.day41.demo08.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.day41.demo08.dao.UserDao;
import cn.itcast.day41.demo08.domain.User;
import cn.itcast.day41.demo08.utils.JdbcUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public List<User> findByBirthday(Date date) throws Exception {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		SimpleDateFormat sdf = new SimpleDateFormat("%-MM-dd");
		String format = sdf.format(date);
		String sql = "select * from tb_user where dirthday like '"+format+"'";
		List<User> list = runner.query(sql, new BeanListHandler<User>(User.class));
		return list;
	}

}
