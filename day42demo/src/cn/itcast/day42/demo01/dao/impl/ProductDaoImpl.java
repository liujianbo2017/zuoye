package cn.itcast.day42.demo01.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.day42.demo01.damain.Product;
import cn.itcast.day42.demo01.dao.ProductDao;
import cn.itcast.day42.demo01.utils.JdbcUtils;

public class ProductDaoImpl implements ProductDao {
	//把表中所有字段的列表定义为一个私有的静态常量，方便所有方法使用
	private static final String FIELDS = "id,name,price,description,img_path ";
	//查询商品
	@Override
	public List<Product> findAll() throws Exception {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select "+FIELDS+" from tb_product";
		List<Product> list = runner.query(sql, new BeanListHandler<Product>(Product.class));
		return list;
	}
	//添加商品
	public void insert(Product product) throws Exception {
		QueryRunner qr = new QueryRunner( JdbcUtils.getDataSource() );
		String sql = "insert into tb_product("+FIELDS+") values(?,?,?,?,?)";
		int r = qr.update(sql , 
				product.getId(),
				product.getName(),
				product.getPrice(),
				product.getDescription(),
				product.getImg_path()
		);
		
		if( r == 0 ){
			//因为要输出整个商品对象的信息，所以需要重写Product对象的toString方法
			throw new Exception("添加失败:"+ product);
		}
	}
	//删除商品
	@Override
	public void delete(String id) throws Exception {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "delete from tb_product where id=?";
		int r = runner.update(sql,id);
		if(r==0){
			//自定义异常
			throw new Exception("删除失败:"+ id);
		}
		
	}
	//根据主键取得商品
	@Override
	public Product get(String id) throws Exception {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select "+FIELDS+" from tb_product where id=?";
		Product product = runner.query(sql, new BeanHandler<Product>(Product.class),id);
		return product;
	}
	//修改商品信息
	@Override
	public void update(Product product) throws Exception {
		QueryRunner qr = new QueryRunner( JdbcUtils.getDataSource() );
		String sql = "update tb_product set name=?,price=?,description=? where id=?";
		int r = qr.update(sql , 
				product.getName(),
				product.getPrice(),
				product.getDescription(),
				product.getId()
		);
		
		if( r == 0 ){
			//因为要输出整个商品对象的信息，所以需要重写Product对象的toString方法
			throw new Exception("修改失败:"+ product);
		}
	}

}
