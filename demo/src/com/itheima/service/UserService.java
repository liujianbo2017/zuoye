package com.itheima.service;

import java.sql.SQLException;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserService {
	private UserDao userDao = new UserDao();
	public User login(String username ,String password){
		User user = null;
		try {
			User u = userDao.findByUsernama(username);
			if(u!=null){
				if(u.getPassword().equals(password)){
					user=u;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
}
