package com.springauemp;

public class logic {
	public double calculateYearlySalary(EmployeeDetails employeeDetails) {
	      double yearlySalary = 0;
	      yearlySalary = employeeDetails.getSal() * 12;
	      return yearlySalary;
	   }
		
	
	   public double calculateAppraisal(EmployeeDetails employeeDetails) {
	      double appraisal = 0;
			
	      if(employeeDetails.getSal() < 10000){
	         appraisal = 500;
	      }else{
	         appraisal = 1000;
	      }
			
	      return appraisal;
	   }

}
