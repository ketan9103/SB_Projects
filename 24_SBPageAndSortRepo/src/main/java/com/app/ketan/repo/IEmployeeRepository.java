package com.app.ketan.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.ketan.entity.Employee;

public interface IEmployeeRepository extends PagingAndSortingRepository<Employee, Integer>,CrudRepository<Employee, Integer>{

}
