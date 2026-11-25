package com.app.ketan.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prod")
public class ProductRestController {
	@GetMapping("/DataA")
	public ResponseEntity<String> showData(@RequestParam("id")Integer pid,
											@RequestParam("name")String pname){
		return new ResponseEntity<>("Id "+pid+" Name "+pname ,HttpStatus.OK);
	}
	
	@GetMapping("/DataB/{id}/{name}")
	public ResponseEntity<String> showDataa(@PathVariable("id")Integer pid,
											@PathVariable("name")String pname){
		return new ResponseEntity<>("Id "+pid+" Name "+pname ,HttpStatus.OK);
	}
}
