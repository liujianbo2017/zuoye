package cn.itcast.day52.demo03;

import cn.itcast.day52.demo03.impl.UserDao;

public class UserService {

	private UserDao userDao = (UserDao) BeanFactory.getBean("userDao2");
	
	public void register(){
		userDao.insert();
	}
	
	public static void main(String[] args) {
		UserService userService = new UserService();
		userService.register();
	}
}
