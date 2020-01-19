package Annotations;

import java.lang.reflect.Method;

import Annotations.MineAnnotation;

public class TestingAnnotation {
	
	public static void main(String args[])throws Exception{  
		
		TestingClass t1 = new TestingClass();
		Method method =t1.getClass().getMethod("testingClassMethod");  
		MineAnnotation  a = method.getAnnotation(MineAnnotation.class);  
		System.out.println("Employee name: "+a.EmployeeName()+" andEmployeeId :"+a.EmployeeId());
		
		TestingClass2 t2= new TestingClass2();
		method =t2.getClass().getMethod("testingclassmethod2");  
		 a = method.getAnnotation(MineAnnotation.class); 
		System.out.println("Default Employee Name: "+a.EmployeeName());
		
		TestingClass3 annotate = new TestingClass3();
		Class<? extends TestingClass3> classType = annotate.getClass();  
		MineAnnotation Annotation = classType.getAnnotation(MineAnnotation.class);  
		System.out.println("class Employee Name: "+Annotation.EmployeeName()+" and EmployeeID:"+Annotation.EmployeeId());
	
		
	}
}