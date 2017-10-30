package cn.itcast.estore.dao;

import java.util.List;
import java.util.Map;

import cn.itcast.estore.domain.Order;
import cn.itcast.estore.domain.OrderItem;

public interface OrderDao {

	void inserOrder(Order order) throws Exception;
	
	void insertOrderItem(OrderItem[] orderItems) throws Exception;
	
	List<Order> findByUidByPage(String uid, int startIndex, int pageSize ) throws Exception;
	
	long getCountByUid(String uid) throws Exception;
	
	List<Map<String,Object>> findOrderItemAndProductByOid(String oid) throws Exception;
	
	Order get(String oid) throws Exception;
	
	void updateState(Order order) throws Exception;
}
