package cn.itcast.demo01.service;

import java.util.List;

import cn.itcast.demo01.damain.Product;

public interface ProductService {

	List<Product> findAll();
	
	boolean add(Product product);
	
	boolean remove(String id);
	
	Product get(String id);
	
	boolean modify(Product product);
}
