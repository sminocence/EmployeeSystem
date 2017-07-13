package com.tedu.test;

import com.tedu.dao.EmpDao;
import com.tedu.entity.Emp;

public class TestCase {
	public static void main(String[] args){
		Emp emp = new Emp();
		emp.setId("2");
		emp.setName("ÀîËÄ");
		emp.setSalary("2000");
		emp.setAge("30");
		EmpDao.addEmp(emp);
		
	}
}
