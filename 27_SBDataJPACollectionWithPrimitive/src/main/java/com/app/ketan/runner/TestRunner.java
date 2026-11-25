package com.app.ketan.runner;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.ketan.entity.Product;
import com.app.ketan.repo.IProductRepository;

@Component
public class TestRunner implements CommandLineRunner{
	@Autowired
	IProductRepository repo;
	
	public void run(String... args) {
		Product pod = new Product();
		pod.setProdId(101);
		pod.setProdName("PEN");
		
		pod.setColors(Arrays.asList("RG","GR","BL"));
		
		Set<String> set = new LinkedHashSet<>();
		set.add("M1");
		set.add("SF");
		set.add("FL");
		
		pod.setModel(set);
		
		Map<String, String> map = new LinkedHashMap<>();
		map.put("D1", "ABC");
		map.put("D2", "XYZ");
		
		pod.setDetails(map);
		
		repo.save(pod);
		
//		Iterable<Product> pob=repo.findAll();
//		for(Product po:pob) {
//			System.out.println(po);
//		}
	}
}
