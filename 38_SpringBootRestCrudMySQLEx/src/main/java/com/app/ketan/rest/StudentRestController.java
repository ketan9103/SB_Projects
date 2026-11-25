package com.app.ketan.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ketan.Exception.StudentNotFoundException;
import com.app.ketan.entity.Student;
import com.app.ketan.service.IStudentService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin({"http://localhost:3000/"})
@RequestMapping("/v1/api/student")
public class StudentRestController {
	@Autowired
	private IStudentService service; 
	
	//1.
	@PostMapping("/create")
	public ResponseEntity<String> createStudent( @RequestBody @Valid Student s) {
		Integer id = service.saveStudent(s);
		String msg = "STUDENT '"+id+"' CREATED";
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	//2.
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudent(){
		List<Student> list = service.getAllStudents();
		return ResponseEntity.ok(list);
	}
	
	//3.
	@GetMapping("/get/{id}")
	public ResponseEntity<Student> getOneStudent(@PathVariable("id")Integer id){
		ResponseEntity<Student> response = null;
		try {
			Student s = service.getOneStudent(id);
			response = ResponseEntity.ok(s);
		}catch (StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}		
		return response;
	}
	
	//4.
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable()Integer id){
		ResponseEntity<String> response = null;
		try {
			service.deleteStudent(id);
			response = ResponseEntity.ok("STUDENT '"+id+"' REMOVED");	
		}catch(StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;
	}
	
	//5.
	@PutMapping("/modify")
	public ResponseEntity<String> updateStudent(@RequestBody @Valid Student s){
		ResponseEntity<String> response = null;
		try {
			service.updateStudent(s);
			response = ResponseEntity.ok("STUDENT '"+s.getStdId()+"' UPDATED");
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;
	}	
}
