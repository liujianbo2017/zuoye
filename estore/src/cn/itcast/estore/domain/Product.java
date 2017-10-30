package cn.itcast.estore.domain;

import java.util.Date;

public class Product {

	/**
	 * 热门商品
	 */
	public static final int HOT = 1;

	/**
	 * 非热门商品
	 */
	public static final int NOT_HOT = 0;

	/**
	 * 商品状态：在售
	 */
	public static final int STATE_SALING = 1;

	/**
	 * 商品状态：下架
	 */
	public static final int STATE_DOWN = 0;

	
	
	private String pid;				//商品ID（主键）
	private String pname;			//名称
	private double shop_price;		//商城价
	private double market_price;	//市场价
	private String pimage;			//图片路径
	private Date pdate;				//创建日期
	private int is_hot;				//是否热门（0是非热门，1是热门）
	private String pdesc;			//描述信息
	private int pflag;				//商品状态（0是下架，1是在售）
	private String cid;				//所属分类ID（外键）
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getShop_price() {
		return shop_price;
	}
	public void setShop_price(double shop_price) {
		this.shop_price = shop_price;
	}
	public double getMarket_price() {
		return market_price;
	}
	public void setMarket_price(double market_price) {
		this.market_price = market_price;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public int getIs_hot() {
		return is_hot;
	}
	public void setIs_hot(int is_hot) {
		this.is_hot = is_hot;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public int getPflag() {
		return pflag;
	}
	public void setPflag(int pflag) {
		this.pflag = pflag;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", shop_price=" + shop_price + ", market_price="
				+ market_price + ", pimage=" + pimage + ", pdate=" + pdate + ", is_hot=" + is_hot + ", pdesc=" + pdesc
				+ ", pflag=" + pflag + ", cid=" + cid + "]";
	}
	
}
