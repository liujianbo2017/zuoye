package cn.itcast.estore.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.estore.dao.CategoryDao;
import cn.itcast.estore.domain.Category;
import cn.itcast.estore.utils.JdbcUtils;

public class CategoryDaoImpl implements CategoryDao {

	private static final String FIELDS = " cid,cname,description ";
	//取得所有的分类
	@Override
	public List<Category> findAll() throws Exception {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select "+FIELDS+" from tb_category";
		List<Category> list = runner.query(sql, new BeanListHandler<Category>(Category.class));
		
		return list;
	}
	//根据传入的其实下标和页大小取得指定页的信息
	@Override
	public List<Category> findByPage(int startIndex, int rows) throws Exception {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select "+FIELDS+" from tb_category limit ?,?";
		List<Category> list = runner.query(sql, new BeanListHandler<Category>(Category.class), startIndex, rows);
			
		return list;
	}
	//取得所有分类的总数
	@Override
	public long getCount() throws Exception {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select count(*) frmo tb_category";
		long count= (long) runner.query(sql, new ScalarHandler());
		System.out.println("aaa"+count);
		return count;
	}
	@Override
	public void delete(String cid) throws Exception {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "delete from tb_category where cid=?";
		int r = runner.update(sql,cid);
		
		if(r==0){
			throw new Exception("删除分类失败"+cid);
		}
	}

}
