package com.app.ketan;

import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("my.app")
public class EmailConfig 
{
	private int phno;
	private String id;
	private Set<String> name;
	
	public int getPhno() {
		return phno;
	}
	public void setPhno(int phno) {
		this.phno = phno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public Set<String> getName() {
		return name;
	}
	public void setName(Set<String> name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "EmailConfig [phno=" + phno + ", id=" + id + ", name=" + name + "]";
	}
	
	
	
}
