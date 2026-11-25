package com.app.ketan.runner;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.ketan.entity.Employee;
import com.app.ketan.repo.IEmployeeRepository;

@Component
public class TestRunner implements CommandLineRunner {


	@Autowired
	IEmployeeRepository repo;

	public void run(String... args) throws Exception {
		repo.saveAll(Arrays.asList(new Employee(101, "AA", 200.0, "DEV"), new Employee(102, "BA", 500.0, "DEV"),
				new Employee(103, "AC", 200.0, "QA"), new Employee(104, "DD", 400.0, "QA"),
				new Employee(105, "EF", 600.0, "DEV")));

		// repo.getAllEmpName()
		// repo.fetchAllEmps()

		repo.getENameEsal().stream().map(obj -> obj[0] + " : " + obj[1]).forEach(System.out::println);

		Optional<String> opt = repo.fetchEmpNameById(102);
		if (opt.isPresent()) {
			System.out.println(opt.get());
		} else {
			System.out.println("Not Present");
		}
	}

}
