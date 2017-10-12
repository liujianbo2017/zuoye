package com.itheima.service;

import com.itheima.dao.LinkmanDao;
import com.itheima.domain.Linkman;

public class LinkmanService {

	public void save(Linkman linkman) throws Exception {
		new LinkmanDao().save(linkman);
	}

}
