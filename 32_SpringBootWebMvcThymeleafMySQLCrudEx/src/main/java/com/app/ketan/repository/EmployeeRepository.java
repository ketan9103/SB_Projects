package com.app.ketan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ketan.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
