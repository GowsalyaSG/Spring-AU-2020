package com.springbu.aspects;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.apringau.main.Employee;
@Service("employeeservice")
public class EmployeeManager{

public List<Employee> getAllEmployee(){
	List<Employee> l=new ArrayList<Employee>();
	l.add(new Employee(112, "gowsalya", "IT", 20));
	l.add(new Employee(113, "anitha", "IT", 20));
	l.add(new Employee(114, "hari", "IT", 20));
	l.add(new Employee(115, "sivan", "IT", 20));
	System.out.println(l);
	return l;
}
}