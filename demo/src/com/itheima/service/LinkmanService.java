package com.itheima.service;

import java.sql.SQLException;

import com.itheima.dao.LinkmanDao;
import com.itheima.domain.Linkman;

public class LinkmanService {
	private LinkmanDao linkmanDao = new LinkmanDao();
	public boolean regist(Linkman lkm){
		boolean flag = false;
		try {
			linkmanDao.insert(lkm);
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
