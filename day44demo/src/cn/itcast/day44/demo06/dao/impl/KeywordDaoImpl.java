package cn.itcast.day44.demo06.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.day44.demo05.utils.JdbcUtils;
import cn.itcast.day44.demo06.dao.KeywordDao;
import cn.itcast.day44.demo06.domain.Keyword;

public class KeywordDaoImpl implements KeywordDao {

	@Override
	public List<Keyword> findByKeyword(String keyword) throws Exception {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from tb_keyword where chineseword LIKE ? OR pinyin LIKE ? OR jianxie LIKE ?";
		String t = "%" + keyword + "%";// %keyword%
		List<Keyword> list = runner.query(sql, new BeanListHandler<Keyword>(Keyword.class),t,t,t);
		
		return list;
	}

}
