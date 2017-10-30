package cn.itcast.day42.demo01.dao;

import java.util.List;

import cn.itcast.day42.demo01.damain.Product;

public interface ProductDao {
	List<Product> findAll()throws Exception;
	
	void insert( Product product)throws Exception;
	
	void delete(String id)throws Exception;
	
	Product get(String id)throws Exception;
	
	void update(Product product)throws Exception;
}
