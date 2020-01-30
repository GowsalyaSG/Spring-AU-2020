package com.springau;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunnable {

	public static void main(String[] args) {
	Result r =JUnitCore.runClasses(junitTest.class);
	for(Failure d:r.getFailures())
	{
		System.out.println(d.toString());
	}
	System.out.println("result "+r.wasSuccessful());
	System.out.println("count "+r.getRunCount());
	}

}
