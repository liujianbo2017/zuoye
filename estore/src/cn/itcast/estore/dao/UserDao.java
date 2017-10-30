package cn.itcast.estore.dao;

import cn.itcast.estore.domain.User;

public interface UserDao {

	void insert( User user ) throws Exception;
	
	void updateState( String code ) throws Exception;
	
	User findByUsername(String username) throws Exception;
}
