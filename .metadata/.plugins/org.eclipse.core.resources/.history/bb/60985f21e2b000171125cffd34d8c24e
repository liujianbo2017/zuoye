package cn.itcast.day43.demo01.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.day43.demo01.dao.ProductDao;
import cn.itcast.day43.demo01.domain.Product;
import cn.itcast.day43.demo01.utils.JdbcUtils;

public class ProductDaoImpl implements ProductDao {
	
	private static final String FIELDS = " id,name,price,description,img_path ";
	
	//得到制定页的商品信息
	@Override
	public List<Product> findByPage(int startIndex, int pageSize) throws Exception {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select "+FIELDS+" from tb_product limit ?,?";
		List<Product> list = runner.query(sql, new BeanListHandler<Product>(Product.class),startIndex,pageSize);
		return list;
	}
	
	//得到商品的总数
	@Override
	public long getCount() throws Exception {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select count(*) from tb_product";
		long count = (long) runner.query(sql, new ScalarHandler());
		return count;
	}

	//根据传入的Product对象中封装的查询条件，生成SQL语句，并执行查询得到符合条件的商品集合
		@Override
		public List<Product> findByCondition(Product condition) throws Exception {
			QueryRunner qr = new QueryRunner( JdbcUtils.getDataSource() );

			StringBuilder sql = new StringBuilder("select ");
			sql.append( FIELDS );
			sql.append(" from tb_product where 1=1 ");
			//select * from tb_product where 1=1 and xxxx  
			
			//判断分类是否有值，有值则添加条件，无值则没有条件
			if( condition.getCategory_id() != null && !"".equals(condition.getCategory_id().trim() ) ){
				sql.append(" and category_id='");
				sql.append(condition.getCategory_id());
				sql.append("'");
			}
			
			//判断商品名称是否有值
			if( condition.getName() != null && !"".equals( condition.getName().trim() ) ){
				sql.append(" and name like '%");
				sql.append(condition.getName());
				sql.append("%'");
			}
			
			List<Product> list = qr.query(sql.toString(), new BeanListHandler<Product>( Product.class ) );
			
			return list;
		}

}
