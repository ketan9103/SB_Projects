package com.app.ketan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmailConfigRunner implements CommandLineRunner {
	@Autowired
	EmailConfig emailConfig;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(emailConfig);
		
	}
}
