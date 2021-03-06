package cn.itcast.day38.demo07.service.impl;

import java.util.List;

import cn.itcast.day38.demo07.dao.ProductDao;
import cn.itcast.day38.demo07.dao.impl.ProductDaoImpl;
import cn.itcast.day38.demo07.domain.Product;
import cn.itcast.day38.demo07.service.ProductService;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao = new ProductDaoImpl();

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
