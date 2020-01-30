package com.springau;

import junit.framework.TestCase;

public class AbsClass extends TestCase{
	protected int v1,v2;
	protected void setUp() {
		v1=13;v2=5;
	}
	public void testsubtract()
	{
		double s=v1-v2;
		assertTrue(s==8);
	}
	public void tearDown() {
		
	}

}
