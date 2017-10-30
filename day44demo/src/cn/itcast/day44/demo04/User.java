package cn.itcast.day44.demo04;

import java.util.Date;

//测试JSON-LIB用的JavaBean
public class User {
		private String id;
		private String name;
		private boolean gender;
		private double salary;
		private Date birthday;
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
		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", salary=" + salary + ", birthday="
					+ birthday + "]";
		}
		public User(String id, String name, boolean gender, double salary, Date birthday) {
			super();
			this.id = id;
			this.name = name;
			this.gender = gender;
			this.salary = salary;
			this.birthday = birthday;
		}
		
		public User(){}

	}
