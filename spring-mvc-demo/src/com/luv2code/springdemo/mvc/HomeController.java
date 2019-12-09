package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping("/")	
	public String showPage() {
		return "main-menu";
	}
	
	@RequestMapping("/_health")	
	@ResponseBody
	public String health() {
		System.out.println("_health check called");
		return "hello world";
	}
}
