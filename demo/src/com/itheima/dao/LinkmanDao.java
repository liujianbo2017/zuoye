package com.itheima.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.domain.Linkman;
import com.itheima.utils.DataSourceUtils;

public class LinkmanDao {
	public void insert(Linkman lkm) throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into linkman(lkm_id,lkm_name,lkm_gender,lkm_mobile,lkm_email,lkm_qq) values(?,?,?,?,?,?)";
		runner.update(sql,lkm.getLkm_id(),lkm.getLkm_name(),lkm.getLkm_gender(),lkm.getLkm_mobile(),lkm.getLkm_email(),lkm.getLkm_qq());
	}

}
