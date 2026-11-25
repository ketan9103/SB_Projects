package com.app.ketan;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ProcessImpl implements IProcess {

	@Override
	public void getProcesCode() {
		System.out.println("P1");
	}

}