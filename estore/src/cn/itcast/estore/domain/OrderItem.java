package cn.itcast.estore.domain;

public class OrderItem {

	private String oid;			//此订单项所属的订单ID
	private String pid;			//此订单项所购买的商品ID
	private int count;			//此订单项所购买的商品数量
	private double subtotal;	//小计
	private Product product;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	@Override
	public String toString() {
		return "OrderItem [oid=" + oid + ", pid=" + pid + ", count=" + count + ", subtotal=" + subtotal + "]";
	}
	
}