package cn.itcast.day44.demo05.dao;

import cn.itcast.day44.demo05.domain.User;

public interface UserDao {
	
	User findByUsername(String username) throws Exception;

}
