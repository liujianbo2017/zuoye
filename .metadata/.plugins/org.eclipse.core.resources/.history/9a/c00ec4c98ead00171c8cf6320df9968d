package com.itheima.service;

import java.sql.SQLException;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserService {
	private UserDao userDao = new UserDao();
	public boolean login(String username ,String password){
		boolean flag = false;
		try {
			User user = userDao.findByUsernama(username);
			if(user!=null){
				if(user.getPassword().equals(password)){
					flag=true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
}
