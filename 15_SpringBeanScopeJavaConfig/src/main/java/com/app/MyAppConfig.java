package com.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//@ComponentScan("com.app")
@Configuration
public class MyAppConfig {
	
	@Bean
	@Scope("prototype")
	public Token t1()
	{
		return new Token();
	}
}
