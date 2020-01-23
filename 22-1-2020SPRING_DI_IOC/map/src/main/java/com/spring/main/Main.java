package com.spring.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.models.Company;

public class Main {

	public static void main(String[] args) 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Company company = context.getBean(Company.class);
		System.out.println(company);
			
	}
}
