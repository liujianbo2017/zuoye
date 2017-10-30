package cn.itcast.estore.service;

import cn.itcast.estore.domain.Order;
import cn.itcast.estore.domain.PageBean;

public interface OrderService {

	boolean generate(String uid,String[] pids, int[] counts);
	
	PageBean<Order> findByUidByPage(String uid, int pageNum, int pageSize);

	Order get(String oid);

	boolean confirm(Order order);
	
}
