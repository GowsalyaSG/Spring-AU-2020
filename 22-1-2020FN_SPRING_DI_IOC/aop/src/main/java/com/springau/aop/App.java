package com.springau.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springbu.aspects.EmployeeManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    	EmployeeManager manager=context.getBean(EmployeeManager.class);
    	manager.getAllEmployee();
    }
    
    
}
