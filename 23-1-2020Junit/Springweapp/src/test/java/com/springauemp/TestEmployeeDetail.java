package com.springauemp;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Test;

public class TestEmployeeDetail {
   logic e=new logic();
   EmployeeDetails e1=new EmployeeDetails();
   @AfterClass
   public static void after()
   {
	   System.out.println("this is end");
   }
	@Test
	public void testCaluculateAppriasal()
	{
		e1.setName("g");
		e1.setAge(23);
		e1.setSal(8000);
		double appraisal =e.calculateAppraisal(e1);
		assertEquals(500.0,appraisal,0.0);
	}
	@Test
	 public void calculateYearlySalary()
	{
		e1.setName("g");
		e1.setAge(23);
		e1.setSal(8000);
		double appraisal =e.calculateYearlySalary(e1);
		assertEquals(8000*12,appraisal,0.0);
	}
	@Test(timeout=5000)
	public void infinity()
	{
		while(true);
	}
}
