package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/apis")
public class example {
    
	static List<Employee> employee = new ArrayList<Employee>();	
    //creating employees by calling get 
	 @GET 
	 @Produces("application/json") 
	 public List<Employee> createemployees() 
     {  
		 
     Employee s1 = new Employee(12,"g","IT",21); 
	 Employee s2 = new Employee(13,"s","cs",20); 
	 Employee s3 = new Employee(14,"r","IT",21); 
	 Employee s4 = new Employee(15,"t","cs",20); 
	  employee.add(s1); 
	  employee.add(s2); 
	  employee.add(s3); 
	  employee.add(s4); 
	  return employee; 
	}
		//getting empid value and return employee details
		@POST
		@Path("posted/{id}")
		@Consumes("application/json")
		@Produces("application/json")
		public Employee postingemployee(@PathParam("id") int id, Employee e) throws NotFoundException{
			for(Employee user:employee) {
				if(user.getEmpId() == id) {	
				
				    return user;
				}
			}
			
			return null;
		}
		
		// updated the names by entering id
		@PUT
		@Path("update/{id}")
		@Consumes("application/json")
		@Produces("application/json")
		public Employee updateEmployee(@PathParam("id") int id, Employee e) throws NotFoundException{
			for(Employee user:employee) {
				if(user.getEmpId() == id) {	
				user.setEmployeeName("friend");
				    return user;
				}
			}
			
			return null;
		}
	 //deleted by name
		@DELETE
		@Path("/deletedbyname/{employeeName}")
		@Produces("application/json")
		public Employee deleteemployee(@PathParam("employeeName") String employeeName) throws NotFoundException {
		    Employee deleted= new Employee();
			for(Employee u:employee) {
				if(u.getEmployeeName().equals(employeeName)) {
					deleted = u;
					employee.remove(u);
					break;
				}
			}
			return deleted;
		}
   //getting all employee details
		 @GET 
		 @Path("/details")
		 @Produces("application/json") 
		 public List<Employee> getAllEmployees() 
	     {  
		  return employee; 
		}

	
}
