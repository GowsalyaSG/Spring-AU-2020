package com.practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;


import com.practice.models.datasource;

@Configuration
@PropertySource("classpath:application.properties")

@ComponentScan(basePackages = "com.*")
public class AppConfig {

	@Autowired
	private Environment env;

	@Bean
	public datasource getPoint() {
		String sqlurl = env.getProperty("sqlurl");
		String username = env.getProperty("users");
		String password = env.getProperty("password");
		System.out.println(sqlurl);
		System.out.println(username);
		return new datasource(sqlurl, username, password);
	}

}
