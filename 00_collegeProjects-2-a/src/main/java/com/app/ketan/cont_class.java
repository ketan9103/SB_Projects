package com.app.ketan;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.ketan.pojo_class_student;

@Controller
public class cont_class {
	List<pojo_class_student> static_data= new ArrayList<>();
	
	@RequestMapping("imr/student/show")
	@ResponseBody
	public List show() {
		return static_data;
	}
	
	
	@RequestMapping("imr/student/insert/{roll}/{name}/{course}")
	@ResponseBody
	public List insert_student(@PathVariable int roll,@PathVariable String name,@PathVariable String course) {
		pojo_class_student obj =new pojo_class_student(roll,name,course);
		static_data.add(obj);
		return static_data;	
	}
	
	@RequestMapping("imr/student/remove/{index}")
	@ResponseBody
	public List remove_student(@PathVariable int index) {
		static_data.remove(index);
		return static_data;	
	}
	
	@RequestMapping("imr/student/update/{index}/{roll}/{name}/{course}")
	@ResponseBody
	public List update_student(@PathVariable int index,@PathVariable int roll,@PathVariable String name,@PathVariable String course) {
		static_data.remove(index);
		pojo_class_student obj =new pojo_class_student(roll,name,course);
		static_data.add(index,obj);
		return static_data;	
	}
	
}
