package cn.itcast.day38.demo07.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.day38.demo07.utils.JdbcUtils;
import cn.itcast.day38.demo07.dao.ProductDao;
import cn.itcast.day38.demo07.domain.Product;

public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> findAll() throws Exception {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from tb_product";
		List<Product> list = runner.query(sql, new BeanListHandler<Product>(Product.class));
		return list;
	}

}
