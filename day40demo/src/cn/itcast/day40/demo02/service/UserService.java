package cn.itcast.day40.demo02.service;

import cn.itcast.day40.demo02.domain.User;

public interface UserService {
	User checkLogin(String username,String password);

}
