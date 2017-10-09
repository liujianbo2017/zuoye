package cn.itcast.day34.demo02.service;

import cn.itcast.day34.demo02.dao.UserDao;
import cn.itcast.day34.demo02.domain.User;

public class UserService {
	//创建UserDao对象,调用dao层方法
	private UserDao dao = new UserDao();
	public boolean login(String username,String password){
		boolean flag = false;
		try {
			User user = dao.findByUserName(username);
			if(user!=null){
				if(user.getPassword().equals(password)){
					return true;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
