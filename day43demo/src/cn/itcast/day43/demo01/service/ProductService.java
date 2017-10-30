package cn.itcast.day43.demo01.service;

import java.util.List;

import cn.itcast.day43.demo01.domain.PageBean;
import cn.itcast.day43.demo01.domain.Product;

public interface ProductService {
	
	PageBean<Product> findByPage(int pageNum, int pageSize);
	
	List<Product> findAllCondition( Product condition);
}
