package com.app.ketan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CodeRunner implements CommandLineRunner{
	@Autowired
	EmailConfig em;
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(em);
	}
	
}
