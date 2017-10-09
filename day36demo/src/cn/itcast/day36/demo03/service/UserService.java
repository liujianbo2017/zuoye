package cn.itcast.day36.demo03.service;

import java.sql.SQLException;

import cn.itcast.day36.demo03.damain.User;
import cn.itcast.day36.demo03.dao.UserDao;

public class UserService {
	private UserDao userDao = new UserDao();
	//注册用户的业务逻辑方法
	public boolean regist(User user){
		boolean flag = false;
		try {
			//调用Dao，写入数据库
			userDao.insert(user);
			//如果没有发生异常,则返回true
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}


}
