package com.spring.models;
import java.util.Map;

public class Company 
{
 public String name;
 public Map<Integer,Employee> employees;
 
 
@Override
public String toString() {
	return "Company [name=" + name +" ]\n "+" employees=" + employees + "]";
}
public String getName() 
{
	return name;
}
public void setName(String name) 
{
	this.name = name;
}


public Map<Integer,Employee> getEmployees()
{
	return employees;
}

public void setEmployees(Map<Integer,Employee> employees)
{
	this.employees = employees;
}

}