package com.app.ketan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.ketan.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query("select emp.empName, dept.deptName from Employee emp INNER JOIN emp.dob as dept")
	List<Object[]> getEnameDeptName();
	
//	@Query("select emp.empName,dept.deptName from Employee emp LEFT OUTER JOIN emp.dob as dept")
	@Query("select emp.empName,dept.deptName from Employee emp LEFT OUTER JOIN emp.dob as dept where dept IS NULL") 
//	@Query("select emp.empName,dept.deptName from Employee emp LEFT OUTER JOIN emp.dob as dept where dept IS NOT NULL") 
	List<Object[]> getAllEnamesAndDeptNamesIfExist();
	
//	@Query("select emp.empName,dept.deptName from Employee emp RIGHT OUTER JOIN emp.dob as dept")
	@Query("select emp.empName, dept.deptName from Employee emp RIGHT OUTER JOIN emp.dob as dept where emp IS NULL")
	List<Object[]> getAllDeptsAndEnamesIfExist();
	
	@Query("SELECT emp.empName, dept.deptName FROM Employee emp INNER JOIN emp.dob as dept WHERE dept.deptName=:deptName")
	List<Object[]> getEnameDeptNames(String deptName);

}
