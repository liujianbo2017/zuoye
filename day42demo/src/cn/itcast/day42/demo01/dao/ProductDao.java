package cn.itcast.day42.demo01.dao;

import java.util.List;

import cn.itcast.day42.demo01.damain.Product;

public interface ProductDao {
	List<Product> findAll()throws Exception;

}
