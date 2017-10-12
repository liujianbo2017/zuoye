package cn.itcast.day42.demo01.service.impl;

import java.util.List;

import cn.itcast.day42.demo01.damain.Product;
import cn.itcast.day42.demo01.dao.ProductDao;
import cn.itcast.day42.demo01.dao.impl.ProductDaoImpl;
import cn.itcast.day42.demo01.service.ProductService;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao = new ProductDaoImpl();
	@Override
	public List<Product> findAll() {
		List<Product> list = null;
		try {
			list = productDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
