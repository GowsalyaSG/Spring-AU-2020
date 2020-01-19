package Annotations;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import Annotations.MineAnnotation;

@Retention(RetentionPolicy.RUNTIME)  
@Target({ElementType.METHOD, ElementType.TYPE}) 
public @interface MineAnnotation {
	int EmployeeId() default 12;
	int age() default 20;
	String EmployeeName() default "GOWSALYA";
	String Role() default "Developer";
}


class TestingClass {  
	@MineAnnotation(EmployeeName="employee1",age=23,EmployeeId=1)  
	public void testingClassMethod(){
		System.out.println("testing class for employee1");  
	}
}

class TestingClass2 {  
	@MineAnnotation
	public void testingclassmethod2(){
		System.out.println("testing class for employee1");
	}  
} 

@MineAnnotation(EmployeeName="Employee2",EmployeeId=3 )
class TestingClass3 {	
}