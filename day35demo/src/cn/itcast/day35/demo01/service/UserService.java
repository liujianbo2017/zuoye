package cn.itcast.day35.demo01.service;

import java.sql.SQLException;

import cn.itcast.day35.demo01.dao.UserDao;
import cn.itcast.day35.demo01.domain.User;

public class UserService {
	private UserDao userDao = new UserDao();
	public boolean login(String username,String password){
		boolean flag = false;
		try {
			User user = userDao.findByUsername(username);
			if(user!=null){
				if(user.getPassword().equals(password)){
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
