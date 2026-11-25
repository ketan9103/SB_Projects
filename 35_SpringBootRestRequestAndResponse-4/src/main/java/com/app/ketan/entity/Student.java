package com.app.ketan.entity;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {
	private Integer sid;
	private String sName;
	private String sGen;
	private Course course;
	
	List<String> langs;
	Map<String, Double> qualif; 
}
