package cn.itcast.day41.demo08.service.impl;

import java.util.Date;
import java.util.List;

import cn.itcast.day41.demo08.dao.UserDao;
import cn.itcast.day41.demo08.dao.impl.UserDaoImpl;
import cn.itcast.day41.demo08.domain.User;
import cn.itcast.day41.demo08.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao = new UserDaoImpl();
	@Override
	public List<User> findBybBirthday() {
		List<User> list = null;
		Date date = new Date();
		try {
			 list = userDao.findByBirthday(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
