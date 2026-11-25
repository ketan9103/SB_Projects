package com.app.ketan.runner;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.app.ketan.entity.Book;
import com.app.ketan.repo.BookRepository;

@Component
public class TestRunner implements CommandLineRunner{

	@Autowired
	private BookRepository repo;

	public void run(String... args) throws Exception {
		repo.saveAll(Arrays.asList(
				new Book(101, "SBMS", "RAGHU", 300.0, "Backend"),
				new Book(102, "CORE", "RAGHU", 200.0, "Backend"),
				new Book(103, "ADV", "ASHOK", 400.0, "Backend"),
				new Book(104, "REACT", null, 500.0, "Frontend"),
				new Book(105, "HTML", "RAGHU", 600.0, "Frontend"),
				new Book(106, "CSS", null, 300.0, "Frontend"),
				new Book(107, "ANGULAR", "ASHOK", 800.0, "Frontend"),
				new Book(108, "SQL", "RAGHU", 200.0, "Database")
				));
//		repo.findByauthor("Ashok").forEach(System.out::println);
//		repo.findByauthorIs("Ashok").forEach(System.out::println);
//		repo.findByBookType("backend").forEach(System.out::println);
//-------------------------------------------------------------------//
		//repo.findByBookCostLessThanEqual(400.0)
		//repo.findByBookIdNot(101)
		//repo.findByBookCostEquals(200)
		//repo.findByBookCostGreaterThan(200)
		//repo.findByBookCostGreaterThanEqual(200)
		//repo.findByAuthorIsNull()
		//repo.findByAuthorIsNotNull()
		//repo.findByAuthorLike("raghu")
		//repo.findByAuthorLikeOrderByBookNameDesc("ashok")
		//repo.findByAuthorNotLike("raghu")
		//repo.findByAuthorStartingWith("A")
		//repo.findByAuthorEndingWith("U")
		//repo.findByAuthorContaining("k")
		//repo.findByBookIdBetween(101, 104)
		//repo.findByBookIdLessThanEqualOrBookTypeLike(105, "Frontend")
		//repo.findByBookCostNotAndAuthorNotLike(200, "raghu")
		//repo.findByAuthorLike("_____")
		//.forEach(System.out::println);
		
		Optional<Book> opt = repo.findByBookIdIs(102);
		if(opt.isPresent()) {
			System.out.println(opt.get());
		}else {
			System.out.println("Not Exist");
		}
			
	}

}
