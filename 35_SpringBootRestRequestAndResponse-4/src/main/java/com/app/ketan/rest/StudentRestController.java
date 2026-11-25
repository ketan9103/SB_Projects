package com.app.ketan.rest;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ketan.entity.Course;
import com.app.ketan.entity.Student;

@RestController
@RequestMapping("/stud")
public class StudentRestController {
	
	@GetMapping("/find")
	public ResponseEntity<Student> getOne(){
		Student std = new Student(112, "Ketan", "Male", new Course(1001, "Java",3000.0), 
				List.of("Marathi","English","Hindi"), Map.of("BCA",79.84,"MCA",56.55));
		ResponseEntity<Student> response = new ResponseEntity<>(std,HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> createStudent(@RequestBody Student std){
		String s = std.toString();
		ResponseEntity<String> response = new ResponseEntity<>(s,HttpStatus.OK);
		return response;
	}
}
