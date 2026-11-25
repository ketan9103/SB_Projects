package com.app.ketan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.ketan.entity.Student;

public interface StudentRepository 
	extends JpaRepository<Student, Integer>
{

}
