package cn.itcast.day44.demo06.service;

import java.util.List;

import cn.itcast.day44.demo06.domain.Keyword;



public interface KeywordService {

	List<Keyword> findByKeyword( String keyword );
}
