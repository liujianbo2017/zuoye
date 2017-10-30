package cn.itcast.estore.service;

import java.util.List;

import cn.itcast.estore.domain.PageBean;
import cn.itcast.estore.domain.Product;

public interface ProductService {

	List<Product> findHots();
	
	List<Product> findNews();
	
	Product get(String pid);
	
	PageBean<Product> findByCategoryByPage(String cid, int pageNum, int pageSize);
}
