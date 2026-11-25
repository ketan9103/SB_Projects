package com.app.ketan.entity;

import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private Integer userId;
	private String userName;
	private String role;
	private String password;
	private Set<String> permissions;
	private Map<String, Integer> nameAndAge;
	
}
