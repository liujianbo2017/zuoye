package cn.itcast.day43.demo01.service.impl;

import java.util.List;

import cn.itcast.day43.demo01.dao.CategoryDao;
import cn.itcast.day43.demo01.dao.impl.CategoryDaoImpl;
import cn.itcast.day43.demo01.domain.Category;
import cn.itcast.day43.demo01.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	private CategoryDao categoryDao = new CategoryDaoImpl();
	
	//取得所有分类
	@Override
	public List<Category> findAll() {
		List<Category> list = null;
		try {
			list = categoryDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
