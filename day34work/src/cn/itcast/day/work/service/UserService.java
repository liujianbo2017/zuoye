package cn.itcast.day.work.service;

import cn.itcast.day.work.dao.UserDao;
import cn.itcast.day.work.domain.User;

public class UserService {
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
