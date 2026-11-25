package com.app.ketan.repo;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.ketan.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{
	//SQL : 1 fetch one Column 
	@Query("SELECT e.empName FROM Employee e")
	List<String> getAllEmpName();
	
	//SQL: 2. select All columns
	@Query("select e from Employee e")
	List<Employee> fetchAllEmps();
	
	//SQL: 3. fetch 2 columns data 
	@Query("select e.empName, e.empSal from Employee e")
	List<Object[]> getENameEsal();
	
	//SQL: 4. fetch one column and one row data
	@Query("select e.empName from Employee e where e.empId = ?1")
	Optional<String> fetchEmpNameById(Integer empId);
	
}
