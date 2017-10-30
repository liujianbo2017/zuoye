package cn.itcast.estore.dao;

import java.util.List;

import cn.itcast.estore.domain.Product;

public interface ProductDao {

	List<Product> findHots() throws Exception;
	
	List<Product> findNews() throws Exception;
	
	Product get(String pid) throws Exception;
	
	List<Product> findByCategoryByPage(String cid, int startIndex, int pageSize) throws Exception;
	
	long getCountByCategory(String cid) throws Exception;
	
}
