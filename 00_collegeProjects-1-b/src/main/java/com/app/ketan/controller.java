package com.app.ketan;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class controller {
	
	@RequestMapping("/home")
	@ResponseBody
	public String msg() {
		return "<h1><marquee>This is Home page</marquee></h1>"
				+ "<a href='/AboutUs'>AboutUs</a><br>"
				+ "<a href='/ContactUs'>ContactUs</a><br>";
	}
	
    @RequestMapping("/AboutUs")
    @ResponseBody
    public String msg1() {
    	return "<h1><marquee>This is About Us page</marquee></h1>"
				+ "<a href='/home'>HomePage</a><br>"
				+ "<a href='/ContactUs'>ContactUs</a><br>";
    }
    
    @RequestMapping("/ContactUs")
    @ResponseBody
    public String msg2() {
    		return "<h1><marquee>This is Contact Us page</marquee></h1>"
    				+ "<a href='/home'>HomePage</a><br>"
    				+ "<a href='/AboutUs'>AboutUs</a><br>";
    }
}
