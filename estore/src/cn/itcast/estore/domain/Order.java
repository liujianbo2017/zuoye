package cn.itcast.estore.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

	//未付款
	public static final int STATE_UNPAY = 1;
	//已付款未发货
	public static final int STATE_PAYED = 2;
	//未付款
	public static final int STATE_SEND = 3;
	//未付款
	public static final int STATE_RECIVED = 4;
	
	private String oid;			//订单ID
	private Date ordertime;		//下单时间
	private double total;		//订单总计
	private int state;			//订单状态：1、未付款。2、已付款未发货。3、已发货未收货。4、已收货
	private String name;		//收货人
	private String address;		//收货地址
	private String telephone;	//收货人电话
	private String uid;			//订单所属用户
	private List<OrderItem> items = new ArrayList<OrderItem>();	//此订单下的所有订单项
	
	
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", ordertime=" + ordertime + ", total=" + total + ", state=" + state + ", name="
				+ name + ", address=" + address + ", telephone=" + telephone + ", uid=" + uid + "]";
	}
	
}
