package cn.itcast.day41.demo08.service;

import java.util.List;

import cn.itcast.day41.demo08.domain.User;

public interface UserService {
	List<User> findBybBirthday();

}
