package cn.itcast.day39.demo01.dao;

import java.util.List;

import cn.itcast.day39.demo01.domain.Product;

public interface ProductDao {
	List<Product> findAll() throws Exception;

}
