package cn.itcast.day43.demo01.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.day43.demo01.dao.CategoryDao;
import cn.itcast.day43.demo01.domain.Category;
import cn.itcast.day43.demo01.utils.JdbcUtils;

public class CategoryDaoImpl implements CategoryDao {
	
	private static final String FIELDS = " id,name ";
	
	//取得所有分类
	@Override
	public List<Category> findAll() throws Exception {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select "+FIELDS+" from tb_category";
		List<Category> list = runner.query(sql, new BeanListHandler<Category>(Category.class));
	
		return list;
	}

}
