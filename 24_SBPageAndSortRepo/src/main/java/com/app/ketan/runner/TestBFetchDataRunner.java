package com.app.ketan.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;

import com.app.ketan.entity.Employee;
import com.app.ketan.repo.IEmployeeRepository;


@Component
public class TestBFetchDataRunner implements CommandLineRunner{
	@Autowired
	private IEmployeeRepository repo;
	
	public void run(String... args) throws Exception {
		repo.saveAll(
				Arrays.asList(
						new Employee(10, "AAA", 200.0, "DEV"),
						new Employee(11, "AAB", 200.0, "QA"),
						new Employee(12, "AAC", 100.0, "BA"),
						new Employee(13, "AAD", 300.0, "DEV"),
						new Employee(14, "AAE", 100.0, "QA"),
						new Employee(15, "AAF", 300.0, "BA"),
						new Employee(16, "AAG", 400.0, "DEV"),
						new Employee(17, "AAH", 400.0, "QA"),
						new Employee(18, "AAJ", 400.0, "BA")
						)
				);
		
		
		System.out.println("Type 1--------------------------");
		repo.findAll(Sort.by("empsal")).forEach(System.out::println);
		
		System.out.println("Type 2--------------------------");
		repo.findAll(Sort.by(Direction.DESC,"empsal")).forEach(System.out::println);
		repo.findAll(Sort.by(Direction.ASC,"empsal")).forEach(System.out::println);
		
		System.out.println("Type 3--------------------------");
		repo.findAll(Sort.by("empsal","dept")).forEach(System.out::println);
		repo.findAll(Sort.by(Direction.DESC,"empsal","dept")).forEach(System.out::println);
		
		System.out.println("Type 4--------------------------");
		repo.findAll(Sort.by(Order.asc("empsal"),Order.desc("dept"))).forEach(System.out::println);
		repo.findAll(Sort.by(Order.desc("empsal"),Order.asc("dept"))).forEach(System.out::println);
		
		
		System.out.println("Paging--------------------");
		Pageable p = PageRequest.of(0, 4);
		
		Page<Employee> pg= repo.findAll(p);
		
		pg.getContent().forEach(System.out::println);
		
		System.out.println(pg.isFirst());
		System.out.println(pg.isLast());
		System.out.println(pg.isEmpty());
		System.out.println(pg.hasNext());
		System.out.println(pg.hasPrevious());
		System.out.println(pg.getTotalElements());
		System.out.println(pg.getTotalPages());
		System.out.println(pg.getSize());
		System.out.println(pg.hasContent());
	}

}
