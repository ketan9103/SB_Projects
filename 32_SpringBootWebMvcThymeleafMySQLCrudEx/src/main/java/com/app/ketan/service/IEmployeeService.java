package com.app.ketan.service;
import java.util.List;
import com.app.ketan.entity.Employee;
import com.app.ketan.service.exception.EmployeeNotFoundException;
public interface IEmployeeService {
	Integer saveEmployee(Employee e);
	void updateEmployee(Employee e);
	void deleteEmployee(Integer id) throws EmployeeNotFoundException ;
	Employee getOneEmployee(Integer id) throws EmployeeNotFoundException ;
	List<Employee> getAllEmployees();
}