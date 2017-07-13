package com.tedu.test;

import java.util.List;

import org.junit.Test;

import com.tedu.dao.EmpDao;
import com.tedu.entity.Emp;

public class Test1 {
	@Test
	public void add(){
		Emp emp = new Emp();
		emp.setId("3");
		emp.setName("“∂π∑◊”");
		emp.setSalary("50000000000");
		emp.setAge("60");
		EmpDao.addEmp(emp);
	}
	@Test
	public void query(){
		String sql = "select * from Emp";
		List<Emp> list = EmpDao.findAll(sql);
		for(Emp e : list){
			System.out.println(e);
		}
	}
	@Test
	public void update(){
		EmpDao.updateName("3", "“∂·Ù·Ù");
	}
	@Test
	public void delete(){
		EmpDao.deleteById("3");
	}
}
