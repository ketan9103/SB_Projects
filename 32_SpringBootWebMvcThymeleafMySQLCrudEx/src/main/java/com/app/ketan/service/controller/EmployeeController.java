package com.app.ketan.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.ketan.entity.Employee;
import com.app.ketan.service.IEmployeeService;
import com.app.ketan.service.exception.EmployeeNotFoundException;

@Controller()
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	IEmployeeService service;
	
	private void calc(Employee employee) {
		double hra = employee.getEmpSal() * (12.0/100);
		double ta = employee.getEmpSal() * (4.0/100);
		employee.setEmpHra(hra);
		employee.setEmpTa(ta);
	}
	/**
	 * 1.SHOW REGISTER PAGE
	 *   This method is used to display Register Page
	 *   when end-user enters /register with GET Type
	 */
	@GetMapping("/register")
	public String showRegPage() {
		return "EmployeeRegister";
	}
	
	/**
	 * 2. ON CLICK FORM SUBMIT, READ DATA (@MODELATTRIBUTE)
	 * This method is used to read Form data as Model Attribute
	 * It will make call to service method by passing same form object
	 * Service method returns PK(ID).
	 * Controller returns String message back to UI using Model
	 * @param employee
	 * @param model
	 * @return
	 */
	
	@PostMapping("/save")
	public String saveFormData(@ModelAttribute Employee employee,Model model) 
	{
		calc(employee);
		Integer id = service.saveEmployee(employee);
		String message ="EMPLOYEE '"+id+"' CREATED";
		model.addAttribute("message", message);
		return "EmployeeRegister";
	}
	
	/***
	 * 3. Display all rows as a table
	 * This method is executed for request URL /all + GET.
	 * It will fetch data from Service as List<T>
	 * Send this data to UI(View) using Model(I)
	 * In UI use th:each="tempVariable:${collectionName}" to read data 
	 * and print as HTML Table.
	 */
	
	@GetMapping("/all")
	public String fetchAll(Model model, 
			@RequestParam(value="message", required=false)String message) {
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list",list);
		model.addAttribute("msg", message);
		return "EmployeeData";
	}
	
	/**
	 * 4. Delete based on id
	 * On Click Delete HyperLink, a Request is made by browser looks like 
	 * /employee/delete?id=someVal.
	 * Read data using Annotation @RequestParam and call service to delete from db.
	 * 
	 * Just redirect to /all with one message (RedirectAttribute)
	 * that will display all rows with message. 
	 */
	
	@GetMapping("/delete")
	public String deleteData(@RequestParam("id")Integer empId, RedirectAttributes redirect) {
		String msg=null;
		try {
			service.deleteEmployee(empId);
			msg = "Employee `"+empId +"` deleted";			
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
			msg = e.getMessage();
		}
		redirect.addAttribute("message",msg);
		return "redirect:all";
	}
	
	/** 
	 * 5. On Click Edit Link(HyperLink) Show data in Edit Form.
	 * When end user clicks on EDIT Link, internal request looks like /edit?empId=10
	 * Read DB Row using service call, that may return employee object else throw exception
	 * (if not found).
	 * If object is present use Model to send that object to Form(UI).
	 * Else redirect to /all with  ErrorMessage(Redirect Attributes).
	 */
	
	@GetMapping("/edit")
	public String editData(@RequestParam("id")Integer empId,
							Model model,
							RedirectAttributes redirect) {		
		String page = null;
		try {
		Employee employee = service.getOneEmployee(empId);
		model.addAttribute("employee", employee);
		page= "EmployeeEdit";
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
			redirect.addAttribute("message",e.getMessage());
			page="redirect:all";
		}
		return page;
	}
	
	@PostMapping("/update")
	public String updateData(@ModelAttribute Employee employee,
								RedirectAttributes attributes) {
		calc(employee);
		service.updateEmployee(employee);
		attributes.addAttribute("message","Employee `"+employee.getEmpId()+"` Updated !");
		return "redirect:all";
	}
	
}
