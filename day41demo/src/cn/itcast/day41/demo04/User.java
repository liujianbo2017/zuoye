package cn.itcast.day41.demo04;

import java.util.Date;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {
	private String id;
	private String name;
	private String password;
	private boolean gender;
	private Date birthday; 
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String id, String name, String password, boolean gender, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.birthday = birthday;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", gender=" + gender + ", birthday="
				+ birthday + "]";
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("User对象和Session绑定啦"+this);
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("User对象和Session解绑啦"+this);
	}

}
