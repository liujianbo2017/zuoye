package cn.itcast.day42.demo01.service.impl;

import java.util.List;

import cn.itcast.day42.demo01.damain.Product;
import cn.itcast.day42.demo01.dao.ProductDao;
import cn.itcast.day42.demo01.dao.impl.ProductDaoImpl;
import cn.itcast.day42.demo01.service.ProductService;
import cn.itcast.day42.demo01.utils.UUIDUtils;

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
		boolean flag = false;
		try {
			// 因为还没有学习文件 上传，所以图片使用现成的，插入到数据库中的路径写死。
			product.setImg_path("/images/cs10001.jpg");
			// 使用工具类生成ID
			product.setId(UUIDUtils.generateID());
			productDao.insert(product);
			flag = true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}

	@Override
	public boolean remove(String id) {
		boolean flag = false;
		try {
			productDao.delete(id);
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
