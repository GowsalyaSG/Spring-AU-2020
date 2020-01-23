package com.spring.models;
public class Employee 
{
	public String name;
	public String dept;
	public int empid;
	public int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", empid=" + empid + ", age=" + age + "]\n";
	}
	
	/*
	 * @Override public String toString() { return "Employee [name=" + name +
	 * ", telNo=" + telNo + "]"; }
	 * 
	 * 
	 * public String getName() { return name; }
	 * 
	 * 
	 * public void setName(String name) { this.name = name; }
	 * 
	 * 
	 * public int getTelNo() { return telNo; }
	 * 
	 * 
	 * public void setTelNo(int telNo) { this.telNo = telNo; }
	 */
}
