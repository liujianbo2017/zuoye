package cn.itcast.day36.demo03.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.day36.demo03.damain.User;
import cn.itcast.day36.demo03.utils.JdbcUtils;

public class UserDao {

	//把用户信息插入数据库
	public void insert(User user) throws SQLException{
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "insert into tb_user(id,username,password) values (?,?,?)";
		runner.update(sql,user.getId(),user.getUsername(),user.getPassword());
	}

}
