package com.itheima.bean;

public class Product {
	private int pid;
	private String pname;
	private double price;
	private String flag;

	public Product() {
		super();
	}

	public Product(int pid, String pname, double price, String flag) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.flag = flag;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", flag=" + flag + "]";
	}

}
