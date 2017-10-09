package cn.itcast.app;

import java.sql.SQLException;
import java.util.List;

//b) 定义SQL语句：查询所有的员工信息 (不包含没有部门的员工)，并将每个员工信息封装到一个Employee对象中。
//
//c) 遍历所有员工信息，查询每个员工的部门信息，并将对象的部门信息封装到Employee内部的Dept对象中；
//
//d) 遍历所有员工信息，打印每个员工的：员工姓名、性别、年龄、所属部门名称。

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.domain.Dept;
import cn.itcast.domain.Employee;
import cn.itcast.tools.JDBCUtils;

public class MainApp {
	public static void main(String[] args) throws SQLException {
		
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		List<Employee> list = runner.query("SELECT * FROM employee WHERE deptid!='NULL'",
				new BeanListHandler<Employee>(Employee.class));
		for (Employee e : list) {
			String sql = "SELECT * FROM employee WHERE id=?";
			Dept dept = runner.query(sql, new BeanHandler<Dept>(Dept.class),e.getDeptid());
			e.setDept(dept);
		}
		for(Employee e : list){
			System.out.println(e);
		}
	}

	
}
