package com.app.ketan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="stud")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sid")
	private Integer stdId;
	
	@Column(name="sname")
	//@NotNull(message = "Name can not be null")
	//@NotEmpty(message="STUDENT NAME CAN NOT BE EMPTY")
	@NotBlank(message = "STUDENT NAME CAN NOT BE BLANK")
	@Size(min = 3, max = 10, message = "name size must in between 3 to 10.")
	@Pattern(regexp = "[A-Za-z]{3,10}",message = "only A-z allowed.")
	private String stdName;
	
	@Column(name="sgen")
	@NotBlank(message="Gen must not blank")
	private String stdGen;
	
	@Column(name="scourse")
	@NotBlank(message = "course not be blank.")
	private String stdCourse;

	@Column(name="saddr")
	@NotBlank(message="Address must not be blank.")
	@Pattern(regexp = "[A-Za-z0-9\\.\\-\\?]{1,250}",message="must in range 1-250 and A-z,0-9,.,-,? is allowed")
	private String stdAddr;
}
