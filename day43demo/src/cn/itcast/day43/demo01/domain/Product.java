package cn.itcast.day43.demo01.domain;

//封装商品信息的JavaBean
public class Product {
	private String id;
	private String name;
	private double price;
	private String description;
	private String img_path;
	private String category_id;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String id, String name, double price, String description, String img_path, String category_id) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.img_path = img_path;
		this.category_id = category_id;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
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
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", img_path=" + img_path + ", category_id=" + category_id + "]";
	}
	
}
