package cn.itcast.day38.demo07.dao;

import java.util.List;

import cn.itcast.day38.demo07.domain.Product;

public interface ProductDao {
	List<Product> findAll() throws Exception;

}
