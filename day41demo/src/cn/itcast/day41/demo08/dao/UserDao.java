package cn.itcast.day41.demo08.dao;

import java.util.Date;
import java.util.List;

import cn.itcast.day41.demo08.domain.User;

public interface UserDao {
	List<User> findByBirthday(Date date)throws Exception;

}
