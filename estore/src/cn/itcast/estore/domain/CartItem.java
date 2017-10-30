package cn.itcast.estore.domain;

//封装购物项信息的JavaBean,表示商品信息,数量,价格小计
public class CartItem {

	private Product product;      //加入购物车中的商品
	private int count;            //加入到购物车中的数量
	private double subtotal;      //小计
	
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItem(Product product, int count, double subtotal) {
		super();
		this.product = product;
		this.count = count;
		this.subtotal = subtotal;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		//购物项的小计=单价*数量
		this.subtotal = product.getShop_price() * count;
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	
}
