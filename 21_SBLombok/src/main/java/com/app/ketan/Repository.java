package com.app.ketan;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Component
@ConfigurationProperties("my.app")
@Setter
@Getter
@ToString
public class Repository{
	String code;

	public Repository() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
