package cn.itcast.day43.demo01.dao;

import java.util.List;

import cn.itcast.day43.demo01.domain.Category;

public interface CategoryDao {
	
	List<Category> findAll()throws Exception;

}
