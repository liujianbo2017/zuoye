package cn.itcast.estore.dao.impl;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.estore.dao.OrderDao;
import cn.itcast.estore.domain.Order;
import cn.itcast.estore.domain.OrderItem;
import cn.itcast.estore.utils.JdbcUtils;

public class OrderDaoImpl implements OrderDao {

	//订单表的所有字段
	private static final String ORDER_FIELDS = " oid,ordertime,total,state,address,name,telephone,uid ";
	
	//订单项表的所有字段
	private static final String ORDER_ITEM_FIELDS = " oid,pid,count,subtotal "; 

	//把订单的信息写入数据库,因为此方法执行时是事物的,所以创建QR对象不能传入连接池
	@Override
	public void inserOrder(Order order) throws Exception {
		QueryRunner runner = new QueryRunner();
		//因为ordertime是时间戳类型，所以在插入数据时不给值，默认就是当前时间。
		String sql = "insert into tb_order("+ORDER_FIELDS.replace("ordertime,", "")+") values(?,?,?,?,?,?,?)";
		//为了实现事物,得到当前线程绑定的连接对象
		Connection conn = JdbcUtils.getConnection();
		
		int r = runner.update(conn, sql,
				order.getOid(),
				order.getTotal(),
				order.getState(),
				order.getAddress(),
				order.getName(),
				order.getTelephone(),
				order.getUid()
			);
		if(r==0){
			throw new Exception("添加订单信息失败: "+ order);
		}
	}

	
	@Override
	public void insertOrderItem(OrderItem[] orderItems) throws Exception {
		QueryRunner runner = new QueryRunner();
		String sql = "insert into tb_orderitem("+ORDER_ITEM_FIELDS+") values(?,?,?,?)";
		Connection conn = JdbcUtils.getConnection();
		
		//创建一个保存所有参数的二维数组,要插入多少条数据,二维数组就有多少行,每条要记录多少个字段,二维数组就有多少列
		Object[][] params = new Object[orderItems.length][4];
		//遍历传入的订单项数组,给要执行的SQL语句时的参数数组赋值
		for (int i = 0; i < orderItems.length; i++) {
			params[i][0] = orderItems[i].getOid();
			params[i][1] = orderItems[i].getPid();
			params[i][2] = orderItems[i].getCount();
			params[i][3] = orderItems[i].getSubtotal();
 		}
		//批量执行
		int[] r = runner.batch(conn, sql, params);
		for (int i = 0; i < r.length; i++) {
			if(r[i]==0){
				throw new Exception("添加订单项失败"+orderItems[i]);
			}
		}

	}


	//分页查询指定用户指定页的的订单
	@Override
	public List<Order> findByUidByPage(String uid, int startIndex, int pageSize) throws Exception {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select "+ORDER_FIELDS+" from tb_order where uid=? order by ordertime desc limit ?,?"; 
		List<Order> list = runner.query(sql, new BeanListHandler<Order>(Order.class) ,uid, startIndex, pageSize);
		
		return list;
	}


	//取得指定用户的订单总数
	@Override
	public long getCountByUid(String uid) throws Exception {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select count(*) from tb_order where uid=?";
		long count = (long) runner.query(sql, new ScalarHandler(),uid);
		
		return count;
	}


	//根据订单ID,取得此订单中所有的订单项和对应的商品,使用内连接查询
	//每条记录中同时有订单项信息和商品信息,保存在一个Map中
	//所有记录(Map),在保存在一个list中
	@Override
	public List<Map<String, Object>> findOrderItemAndProductByOid(String oid) throws Exception {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from tb_orderitem a,tb_product b where oid=? and a.pid=b.pid";
		List<Map<String,Object>> list = runner.query(sql, new MapListHandler(),oid);
		
		return list;
	}


	//根据订单ID.,得到订单信息
	@Override
	public Order get(String oid) throws Exception {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "SELECT "+ORDER_FIELDS+" FROM tb_order WHERE oid=?";
		Order order = runner.query(sql, new BeanHandler<Order>(Order.class),oid);
		
		return order;
	}


	//更新订单信息,把状态给为2,并填入收货信息
	@Override
	public void updateState(Order order) throws Exception {
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "update tb_order set state=?,address=?,name=?,telephone=? where oid=?";
		int r = runner.update( sql ,
				order.getState(),
				order.getAddress(),
				order.getName(),
				order.getTelephone(),
				order.getOid()
		);
		if(r==0){
		throw new Exception("付款失败!请联系银行管理员" + order);
	}
	}

}
