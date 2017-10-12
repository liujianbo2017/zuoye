package cn.itcast.day40.demo02.service.impl;

import cn.itcast.day40.demo02.dao.UserDao;
import cn.itcast.day40.demo02.dao.impl.UserDaoImpl;
import cn.itcast.day40.demo02.domain.User;
import cn.itcast.day40.demo02.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();
	@Override
	public User checkLogin(String username, String password) {
		User user = null;
		try {
			User u=userDao.findByUsername(username);
			if(u!=null){
				if(u.getPassword().equals(password)){
					user=u;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
