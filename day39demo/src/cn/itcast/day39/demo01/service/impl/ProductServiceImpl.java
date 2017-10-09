package cn.itcast.day39.demo01.service.impl;

import java.util.List;

import cn.itcast.day39.demo01.dao.ProductDao;
import cn.itcast.day39.demo01.dao.impl.ProductDaoImpl;
import cn.itcast.day39.demo01.domain.Product;
import cn.itcast.day39.demo01.service.ProductService;

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
