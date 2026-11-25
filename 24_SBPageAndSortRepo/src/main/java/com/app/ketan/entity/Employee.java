package com.app.ketan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="emp")
public class Employee {
	@Id
	@Column(name="eid")
	private Integer empId;
	
	@Column(name="ename")
	private String empname;
	
	@Column(name="esal")
	private double empsal;
	
	@Column(name="edept")
	private String dept;
}
