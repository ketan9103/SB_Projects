package com.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {
	@Bean
	public DriverManager conObj()
	{
		DriverManager dm = new DriverManager();
		dm.setDriverClass("ORACLE");
		dm.setUrl("JDBC:ORACLE:THIN");
		return dm;
	}

}
