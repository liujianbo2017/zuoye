package cn.itcast.day43.demo01.dao;

import java.util.List;

import cn.itcast.day43.demo01.domain.Product;

public interface ProductDao {
	
	List<Product> findByPage(int startIndex , int pageSize)throws Exception;
	
	long getCount()throws Exception;
	
	List<Product> findByCondition(Product condition) throws Exception;
	

}
