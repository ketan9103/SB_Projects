package com.app.ketan.rest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ketan.entity.Role;
import com.app.ketan.entity.User;

@RestController
@RequestMapping("/user")
public class UserReSTController {
	
	@GetMapping("/one")
	public ResponseEntity<User> getOneObj(){
		User ob = new User(1223, "ketan","QA", "1234",
								Set.of("P1","P2","P3"),
								Map.of("Raj",12,"Rahul",21,"Bhavesh",20));
		
		ResponseEntity<User> response = new ResponseEntity<>(ob,HttpStatus.OK);
		return response;
	}
	 
	@GetMapping("/role")
	public ResponseEntity<List<Role>> listOfUser(){
		List<Role> list = Arrays.asList(
							new Role(001,"QA"),
							new Role(002,"Dev"),
							new Role(003,"BA")
				);
		ResponseEntity<List<Role>> response = new ResponseEntity<>(list,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/map")
	public ResponseEntity<Map<String, Role>> getMapRole(){
		Map<String,Role> map = Map.of(   "R1",new Role(001,"QA"),
										"R2",new Role(002,"Dev"),
										"R3",new Role(003,"BA"));
		ResponseEntity<Map<String,Role>> response = new ResponseEntity<>(map,HttpStatus.OK);
		return response;
	}
	
}
