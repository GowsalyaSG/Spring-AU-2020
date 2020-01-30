package com.practice.mockito;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {
	
   @InjectMocks 
   MathApplication mathApplication = new MathApplication();

   @Mock
   CalculatorService calcService;

   @Test
   public void testAdd(){
	   
      //add the behavior of calc service to add/subtract/multiply/delete two numbers
	   
      when(calcService.add(10.0,20.0)).thenReturn(30.00);
      when(calcService.subtract(20.0,10.0)).thenReturn(10.0);
      when(calcService.multiply(10.0,20.0)).thenReturn(200.00);
      when(calcService.divide(20.0,10.0)).thenReturn(2.0);
       //calcService.divide(20.0,10.0);
		
      //test the add/subtract/multiply/delete functionality
      
      Assert.assertEquals(calcService.add(10.0, 20.0),30.0,0);
      Assert.assertEquals(calcService.subtract(20.0, 10.0),10.0,0);
      Assert.assertEquals(calcService.multiply(10.0, 20.0),200.0,0);
      Assert.assertEquals(calcService.divide(20.0, 10.0),2.0,0);	
      //Assert.assertEquals(calcService.divide(10.0, 10.0),2.0,0);	
      
      //testing the order
      
		  InOrder inOrder = inOrder(calcService);
		  
		  inOrder.verify(calcService).add(10.0,20.0);
		  inOrder.verify(calcService).subtract(20.0,10.0);
		  inOrder.verify(calcService).multiply(10.0,20.0);
		  inOrder.verify(calcService).divide(20.0,10.0);
		
		  
     //testing no.of called
		  
      verify(calcService, times(1)).add(10.0, 20.0);
      verify(calcService, times(1)).subtract(20.0,10.0);
	  verify(calcService, times(1)).multiply(10.0,20.0);
	  verify(calcService, times(1)).divide(20.0,10.0);
	 // verify(calcService, times(2)).divide(20.0,10.0);

    
      verify(calcService).add(10.0, 20.0);
      verify(calcService).subtract(20.0, 10.0);
	  verify(calcService).multiply(10.0,20.0);
	  verify(calcService).divide(20.0,10.0);
   }
}