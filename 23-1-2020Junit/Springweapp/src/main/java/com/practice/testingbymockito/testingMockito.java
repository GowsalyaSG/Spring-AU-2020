package com.practice.testingbymockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.practice.controller.MainController;
import com.practice.models.Employee;


import dao.EmployeeDao;


public class testingMockito {
	@Test
	public void testusing_Mocks() throws ClassNotFoundException, NoSuchFieldException, SecurityException
	{
		EmployeeDao employeeDAO=mock(EmployeeDao.class);
		Employee  employee=new Employee();
        employee.setId(2);
		employee.setFname("dnjka");
		when(employeeDAO.getById(1)).thenReturn(employee);
		assertEquals("dnjka",employeeDAO.getById(1).getFname());
		//correct
	}
	@Test
	public void testusing_Mocks1() throws ClassNotFoundException, NoSuchFieldException, SecurityException
	{
		EmployeeDao employeeDAO=mock(EmployeeDao.class);
		Employee  employee=new Employee();
		
		employee.setId(2);
		employee.setPhone("324");
		when(employeeDAO.getById(1)).thenReturn(employee);

		System.out.println(employeeDAO.getById(1).getPhone());
		assertEquals("32344",employeeDAO.getById(1).getPhone());
		//wrong
	}
	/*@Test
	void testGet() {
		Integer id=0;
		EmployeeDao employeeDAO=mock(EmployeeDao.class);
		Employee  contact=new Employee();
		if(contact!=null)
		{
			//System.out.println(contact);
		}
		assertNotNull(contact);
		
	}*/
		
}
