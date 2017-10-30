package cn.itcast.day44.demo06.dao;

import java.util.List;

import cn.itcast.day44.demo06.domain.Keyword;

public interface KeywordDao {

	List<Keyword> findByKeyword( String keyword ) throws Exception;
}
