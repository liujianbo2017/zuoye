package cn.itcast.day41.demo05;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class Product implements HttpSessionActivationListener,Serializable {
	private String id;
	private String name;
	private double price;
	private String description;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String id, String name, double price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + "]";
	}

	@Override//钝化之前
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("此Product将要钝化"+this);
	}

	@Override//活化之后
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("此Product会活化"+this);
	}

}
