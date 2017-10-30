package cn.itcast.demo01.dao;

import java.util.List;

import cn.itcast.demo01.damain.Product;

public interface ProductDao {

	List<Product> findAll() throws Exception;
	
	void insert(Product product) throws Exception; 
	
	void dalete(String id) throws Exception;
	
	Product get(String id) throws Exception; 
	
	void update(Product product) throws Exception;
	
}
