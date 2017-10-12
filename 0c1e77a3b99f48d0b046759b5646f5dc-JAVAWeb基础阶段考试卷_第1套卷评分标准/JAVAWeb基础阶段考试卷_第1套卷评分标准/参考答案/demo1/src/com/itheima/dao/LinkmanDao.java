package com.itheima.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.domain.Linkman;
import com.itheima.utils.DataSourceUtils;

public class LinkmanDao {

	public void save(Linkman l) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into linkman values(null,?,?,?,?,?)";
		/**
		 * lkm_name varchar(16) DEFAULT NULL COMMENT '联系人姓名',
		  lkm_gender varchar(16) DEFAULT NULL COMMENT '联系人性别',
		  lkm_mobile varchar(16) DEFAULT NULL COMMENT '联系人手机',
		  
		  lkm_email varchar(64) DEFAULT NULL COMMENT '联系人邮箱',
		  lkm_qq varchar(16) DEFAULT NULL COMMENT '联系人qq'
		 */
		qr.update(sql, l.getLkm_name(),l.getLkm_gender(),l.getLkm_mobile(),
				l.getLkm_email(),l.getLkm_qq());
	}

}
