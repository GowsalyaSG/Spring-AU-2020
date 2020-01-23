package com.springau.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import com.springau.config.AppConfig;
import com.springau.services.FileServiceImpl;
 
public class Main {
     
    public static void main(String args[]){
        ApplicationContext  context = new AnnotationConfigApplicationContext(AppConfig.class);
        FileServiceImpl service = (FileServiceImpl) context.getBean(FileServiceImpl.class);
        service.readValues();
    }
     
}