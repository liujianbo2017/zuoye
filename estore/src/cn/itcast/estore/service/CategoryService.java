package cn.itcast.estore.service;

import java.util.List;

import cn.itcast.estore.domain.Category;
import cn.itcast.estore.domain.PaginationBean;

public interface CategoryService {

	List<Category> findAll();
	
	String findAllJson();
	
	PaginationBean<Category> findByPage(int page , int rows);
	
	boolean delete(String cid);
	
}
