package com.tedu.entity;

/*
 * 实体类
 */
public class Emp {
	private String id;
	private String name;
	private String age;
	private String salary;
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {//有了这个toString方法，就可以直接输出Emp对象
		return "Emp [age=" + age + ", id=" + id + ", name=" + name
				+ ", salary=" + salary + "]";
	}
	
	
	
}
