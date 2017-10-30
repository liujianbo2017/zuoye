package cn.itcast.day48.demo03;

import java.io.Serializable;
import java.util.Date;

//因为需要把对象变成二进制数保存到Redis中，所以此类必须实现序列化接口
public class User implements Serializable {
	private static final long serialVersionUID = 3566937892099256432L;
	private String username;
	private String name;
	private boolean gender;
	private double salary;
	private Date birthday;
	
	public User(){}
	
	public User(String username, String name, boolean gender, double salary, Date birthday) {
		super();
		this.username = username;
		this.name = name;
		this.gender = gender;
		this.salary = salary;
		this.birthday = birthday;
	}

	
	
	@Override
	public String toString() {
		return "User [username=" + username + ", name=" + name + ", gender=" + gender + ", salary=" + salary
				+ ", birthday=" + birthday + "]";
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
