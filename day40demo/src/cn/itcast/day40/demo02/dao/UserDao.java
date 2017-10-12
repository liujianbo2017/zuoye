package cn.itcast.day40.demo02.dao;

import cn.itcast.day40.demo02.domain.User;

public interface UserDao {
	User findByUsername(String username)throws Exception;

}
