package com.springau.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.springau.services.Point;
@Service("fileServiceImpl")
public class FileServiceImpl  {
  
    @Autowired
    private Environment environment;
    public void readValues() {
  	 Point p =new Point(Integer.parseInt(environment.getProperty("x")),Integer.parseInt(environment.getProperty("y")));
    	 System.out.println(p);
    }
 
}