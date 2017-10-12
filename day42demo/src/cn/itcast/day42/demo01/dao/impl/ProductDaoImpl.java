package cn.itcast.day42.demo01.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.day42.demo01.damain.Product;
import cn.itcast.day42.demo01.dao.ProductDao;
import cn.itcast.day42.demo01.utils.JdbcUtils;

public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> findAll() throws Exception {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from tb_product";
		List<Product> list = runner.query(sql, new BeanListHandler<Product>(Product.class));
		return list;
	}

}
