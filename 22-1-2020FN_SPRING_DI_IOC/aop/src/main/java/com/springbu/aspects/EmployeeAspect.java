package com.springbu.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.time.*;
import java.util.*;


@Aspect
public class EmployeeAspect {
	long starttime,endtime ;
	@Before("execution(* com.springbu.aspects.EmployeeManager.getAllEmployee(..))")
	public void logBeforeV1(JoinPoint joinPoint) {
	starttime = System.currentTimeMillis();
		System.out.println("starting time "+starttime+"\n "+"EmployeeAspect.logBefore() : "+joinPoint.getSignature().getName());
		
	}
	@After("execution(* com..springbu.aspects.EmployeeManager.getAllEmployee(..))")
	public void AfterBeforeV1(JoinPoint joinPoint) {
		 endtime = System.currentTimeMillis();
		long diff=endtime-starttime;
		System.out.println("\nending time "+endtime+"\n ");
		System.out.println("EmployeeAspect.logBefore() : "+joinPoint.getSignature().getName());
		System.out.println("time diff :"+diff);
	}
}
