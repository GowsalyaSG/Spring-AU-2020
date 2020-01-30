package com.springau;

import org.junit.Assert;
import org.junit.Test;

public class TestDemo1 {

	 @Test
		public void testString()
		{
			String abc="this";
			Assert.assertEquals("this", abc);
		}
	 @Test
		public void testadd()
		{
			int a=10,b=8,c;
			c=a+b;
			Assert.assertEquals(c,18);
		}
}
