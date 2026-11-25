package com.app;

import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Scope("singleton")
@Scope("prototype")
@Component("t1")
public class Token {
	private int code;
	
	public Token() {
		super();
		code = Math.abs( new Random().nextInt() );
	}


	@Override
	public String toString() {
		return "Token [code=" + code + "]";
	}


}
