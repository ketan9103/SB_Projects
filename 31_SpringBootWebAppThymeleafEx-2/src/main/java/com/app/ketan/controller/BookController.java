package com.app.ketan.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.ketan.bean.Book;

@RequestMapping("/book")
@Controller
public class BookController {
	@GetMapping("/info")
	public String showAll(Model model) {
		Book b1 = new Book(101,"Java","JemsGosling",200.0);
		model.addAttribute("book1", b1);		
		return "BookData";
	}
	
	@GetMapping("/show")
	public String ShowData(Model model) {
		List<Book> list = Arrays.asList(
					new Book(101,"Java","JemsGosling",200.0),
					new Book(102,".Net","Twinder",400.0),
					new Book(103,"C#","Trump",240.0),
					new Book(104,"JavaScript","Jems",500.0),
					new Book(105,"Css","Krish",560.0),
					new Book(106,"HTML","Salman",460.0),
					new Book(107,"C++","Jorge",100.0)
				);
		model.addAttribute("Books",list);
		
		return "BookData";
	}
}
