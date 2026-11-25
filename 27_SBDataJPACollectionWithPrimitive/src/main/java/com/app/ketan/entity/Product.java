package com.app.ketan.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="prod_52")
public class Product {
	@Id
	@Column(name="pid")
	private Integer prodId;
	@Column(name="pname")
	private String prodName;
	
	@ElementCollection
	@CollectionTable(name="product_color", //Table Name
					joinColumns = @JoinColumn(name="pidFK")) // Foreign Key Column
	@OrderColumn(name="pos")  //index
	@Column(name="data")	//Element Column
	List<String> colors;
	
	@ElementCollection
	@CollectionTable(name="product_model", joinColumns = @JoinColumn (name="pidFk"))
	@Column(name="model") //Element Column
	private Set<String> model; 
	
	@ElementCollection
	@CollectionTable(name="product_detail",joinColumns = @JoinColumn(name="pidFK"))
	@MapKeyColumn(name="code") //index column
	@Column(name="details") //Element Column
	private Map<String, String> details;
	
}
