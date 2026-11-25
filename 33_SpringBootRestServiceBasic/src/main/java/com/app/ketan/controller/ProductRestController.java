package com.app.ketan.controller;

import com.app.ketan.Application;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductRestController {

  
	//1. Fetch Resource
	//@RequestMapping(value="/fetch", method=RequestMethod.GET)
	@GetMapping("/fetch")
	public ResponseEntity<String> getProduct() {
		ResponseEntity<String> response =  new ResponseEntity<>("FROM GET OPERATION",HttpStatus.OK);
		return response;
	}
	
	//2. Save Resource
	@PostMapping("/save")
	public ResponseEntity<String> saveData(){
		ResponseEntity<String> response = new ResponseEntity<>("FROM POST OPERATION",HttpStatus.OK);
		return response;
	}
	
	//3. Update Resource
	@PutMapping("/update")
	public ResponseEntity<String> updateData(){
		ResponseEntity<String> response = new ResponseEntity<>("FROM PUT OPERATION",HttpStatus.OK);
		return response;
	}
	
	//4. Delete Resource
	@DeleteMapping("/del")
	public ResponseEntity<String> deleteProduct(){
		ResponseEntity<String> response = new ResponseEntity<>("FROM DELETE OPERATION",HttpStatus.OK);
		return response;
	}
	
	//5. Partial Update of Resource
	@PatchMapping("/updateCost")
	public ResponseEntity<String> updateCost(){
		ResponseEntity<String> response = new ResponseEntity<>("FROM PATCH OPERATION",HttpStatus.OK);
		return response;
	}	
}
