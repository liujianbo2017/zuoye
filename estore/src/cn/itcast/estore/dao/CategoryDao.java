package cn.itcast.estore.dao;

import java.util.List;

import cn.itcast.estore.domain.Category;

public interface CategoryDao {

	List<Category> findAll() throws Exception;
	
	List<Category> findByPage( int startIndex, int rows) throws Exception;
	
	long getCount() throws Exception;
	
	void delete(String cid) throws Exception;
}
