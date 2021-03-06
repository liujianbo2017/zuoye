package cn.itcast.estore.service;

import cn.itcast.estore.dao.CategoryDao;
import cn.itcast.estore.dao.OrderDao;
import cn.itcast.estore.dao.ProductDao;
import cn.itcast.estore.dao.UserDao;
import cn.itcast.estore.dao.impl.CategoryDaoImpl;
import cn.itcast.estore.dao.impl.OrderDaoImpl;
import cn.itcast.estore.dao.impl.ProductDaoImpl;
import cn.itcast.estore.dao.impl.UserDaoImpl;

public class BaseService {

	protected UserDao userDao = new UserDaoImpl();
	
	protected CategoryDao categoryDao = new CategoryDaoImpl();
	
	protected ProductDao productDao = new ProductDaoImpl();
	
	protected OrderDao orderDao = new OrderDaoImpl();
}
