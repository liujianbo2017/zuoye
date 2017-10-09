package cn.itcast.domain;

public class Employee {
	private int id;
	private String name;
	private double age;
	private String sex;
	private double salary;
	private String empdate;
	private double deptid;
	private Dept Dept;

	public Employee() {
		super();
	}

	public Employee(int id, String name, double age, String sex, double salary, String empdate, double deptid,
			Dept dept) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.salary = salary;
		this.empdate = empdate;
		this.deptid = deptid;
		Dept = dept;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmpdate() {
		return empdate;
	}

	public void setEmpdate(String empdate) {
		this.empdate = empdate;
	}

	public double getDeptid() {
		return deptid;
	}

	public void setDeptid(double deptid) {
		this.deptid = deptid;
	}

	public Dept getDept() {
		return Dept;
	}

	public void setDept(Dept dept) {
		Dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", salary=" + salary
				+ ", empdate=" + empdate + ", deptid=" + deptid + ", Dept=" + Dept + "]";
	}

}
