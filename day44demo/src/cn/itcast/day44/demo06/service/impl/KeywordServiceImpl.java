package cn.itcast.day44.demo06.service.impl;

import java.util.List;

import cn.itcast.day44.demo06.dao.KeywordDao;
import cn.itcast.day44.demo06.dao.impl.KeywordDaoImpl;
import cn.itcast.day44.demo06.domain.Keyword;
import cn.itcast.day44.demo06.service.KeywordService;

public class KeywordServiceImpl implements KeywordService{

	private KeywordDao keywordDao = new KeywordDaoImpl();
	
	@Override
	public List<Keyword> findByKeyword(String keyword) {
		List<Keyword> list = null;
		
		try {
			list = keywordDao.findByKeyword(keyword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	
}
