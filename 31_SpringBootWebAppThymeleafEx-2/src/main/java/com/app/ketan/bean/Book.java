package com.app.ketan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	private Integer bId;
	private String bName;
	private String bAuth;
	private Double bPrice;
}
