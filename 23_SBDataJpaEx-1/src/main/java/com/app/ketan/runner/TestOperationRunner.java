package com.app.ketan.runner;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.app.ketan.Application;
import com.app.ketan.entity.Product;
import com.app.ketan.exception.ProductNotFoundException;
import com.app.ketan.repo.IProductRepository;

@Component
public class TestOperationRunner implements CommandLineRunner {
	@Autowired
	private IProductRepository repo;

	public void run(String... args) throws Exception {
		System.out.println(repo.getClass().getName());		//jdk.proxy2.$Proxy104
		Product p1 = new Product(10,"P1",100.00);
		Product p2 = new Product(11,"P2",200.00);
		Product p3 = new Product(12,"P3",300.00);
		Product p4 = new Product(13,"P4",100.00);
		Product p5 = new Product(14,"P5",200.00);
		Product p6 = new Product(15,"P6",500.00);
		
		
		System.out.println("****Save****");
//		repo.save(p1);
//		repo.save(p2);
//		Hibernate: select p1_0.pid,p1_0.pcost,p1_0.pname from product_tab p1_0 where p1_0.pid=?
//		Hibernate: insert into product_tab (pcost,pname,pid) values (?,?,?)
		repo.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6));
		
		
		System.out.println("-----------------1.-----------------");
		
		System.out.println("****Find****");
		Iterable<Product> data = repo.findAll();
		// JDK 1.5 forEach Loop
		for(Product pob: data) {
			System.out.println(pob);
		}
		
		System.out.println("-----------------2.-----------------");
		// JDK 1.8 Default method + Lambda expression
		data.forEach(ob -> 
						System.out.println(ob));
		
		System.out.println("-----------------3.------------------");
		data.forEach(System.out::println);//internally works as Lambda expression [.ForEach(ob -> System.out.println();]
		
		System.out.println("****exist****");
		System.out.println("---------------------");
		System.out.println(repo.existsById(11));//returns true or false
		System.out.println(repo.existsById(33));
		
		
		System.out.println("****Count****");
		System.out.println(repo.count());// counts no. of rows present in the table
		
		System.out.println("***********************************************************************************");
		System.out.println("------------------1---------------------");
		System.out.println(repo.findById(11));
		
		System.out.println("------------------2---------------------");
		Optional<Product> opt = repo.findById(17);
		if(opt.isPresent()) {
			Product p = opt.get();
			System.out.println(p);
		}else {
			System.out.println("Data does not Exist...");
		}
		
		System.out.println("------------------3--------------------");
		Product p = repo.findById(12).orElseThrow(()-> new ProductNotFoundException("NOT EXIST"));
		System.out.println(p);
		
		System.out.println("------------------4--------------------");
		Iterable<Product> list= repo.findAllById(Arrays.asList(11,12,13));
		list.forEach(System.out::println);
		
		System.out.println("****Delete****");
		System.out.println("-----------------1.----------------------");
		//repo.deleteById(11);
		
		System.out.println("-----------------2.--------------------");
		repo.delete(repo.findById(10).
							orElseThrow(()-> 
								new ProductNotFoundException(
										String.format("%s is not having %d", Product.class.getName(),10)
										)
								)
							);
		
		System.out.println("-----------------3.--------------------");
		repo.deleteAllById(Arrays.asList(11,12,13));;
		
		System.out.println("-----------------4.--------------------");
		repo.deleteAll();
		
		Iterable<Product> data1 = repo.findAll();
		data1.forEach(System.out::println);
		
		
	}

}
