package cn.itcast.app;

import java.sql.SQLException;
import java.util.List;

//b) ����SQL��䣺��ѯ���е�Ա����Ϣ (������û�в��ŵ�Ա��)������ÿ��Ա����Ϣ��װ��һ��Employee�����С�
//
//c) ��������Ա����Ϣ����ѯÿ��Ա���Ĳ�����Ϣ����������Ĳ�����Ϣ��װ��Employee�ڲ���Dept�����У�
//
//d) ��������Ա����Ϣ����ӡÿ��Ա���ģ�Ա���������Ա����䡢�����������ơ�

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
