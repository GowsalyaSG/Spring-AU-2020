package com.springau.mockito;
import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when; 
import java.util.Arrays;
import java.util.List;

import org.junit.Test;



public class ToDoBusinessMock
{
	@Test
	public void testusing_Mock(){
		ToDoService d=mock(ToDoService.class);
		List<String> combinedlist = Arrays.asList("use Core Java","Use Spring Core","Use w3eHibernate");
		when(d.getTodos("dummy")).thenReturn(combinedlist);
		
		ToDoBusiness business = new ToDoBusiness(d);
		List<String> alltd =business.getTodosforHibernate("dummy");
		System.out.println(alltd);
		assertEquals(1,alltd.size());
	}
	
}
