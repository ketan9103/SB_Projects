package com.app.ketan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ketan.entity.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {

}
