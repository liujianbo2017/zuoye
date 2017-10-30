package cn.itcast.demo01.service.impl;

import java.util.List;
import java.util.UUID;

import cn.itcast.demo01.damain.Product;
import cn.itcast.demo01.dao.ProductDao;
import cn.itcast.demo01.dao.impl.ProductDaoImpl;
import cn.itcast.demo01.service.ProductService;
import cn.itcast.demo01.utils.UUIDUtils;

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
	@Override
	public boolean add(Product product) {
		
		boolean falg = false;
		try {
			product.setImg_path("/images/cs10001.jpg");
			product.setId(UUIDUtils.generateID());
			productDao.insert(product);
			falg = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return falg;
	}
	@Override
	public boolean remove(String id) {
		boolean flag = false;
		    try {
				productDao.dalete(id);
				flag = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return flag;
	}
	@Override
	public Product get(String id) {
		Product product = null;
		try {
			product = productDao.get(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}
	@Override
	public boolean modify(Product product) {
		boolean flag = false;
		try {
			productDao.update(product);
			flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
