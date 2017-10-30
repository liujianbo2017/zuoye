package cn.itcast.day44.demo05.service.impl;

import cn.itcast.day44.demo05.dao.UserDao;
import cn.itcast.day44.demo05.dao.impl.UserDaoImpl;
import cn.itcast.day44.demo05.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userDao = new UserDaoImpl();
	@Override
	public boolean isUsernameUsable(String username) {
		boolean flag = false;
		try {
			userDao.findByUsername(username);
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
