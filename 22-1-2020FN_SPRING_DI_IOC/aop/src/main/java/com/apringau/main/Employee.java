package com.apringau.main;

public class Employee {
	private Integer empId;
	private String employeeName;
	private String dept;
	private int age;
	public Employee(Integer empId, String employeeName, String dept, int age) {
		super();
		this.empId = empId;
		this.employeeName = employeeName;
		this.dept = dept;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", employeeName=" + employeeName + ", dept=" + dept + ", age=" + age + "]";
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	

}
