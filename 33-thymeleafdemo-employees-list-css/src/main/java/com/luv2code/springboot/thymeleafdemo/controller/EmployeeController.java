package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private List<Employee> theEmployees;
	
	@PostConstruct
	private void loadData() {
		theEmployees = new ArrayList<Employee>();
		theEmployees.add(new Employee(1, "Leslie", "Andrews", "leslie@luv2code.com"));
		theEmployees.add(new Employee(2, "Emma", "Baumgarten", "emma@luv2code.com"));
		theEmployees.add(new Employee(3, "Avani", "Gupta", "avani@luv2code.com"));
	}
	
	@GetMapping("/list")
	public String getAll(Model theModel) {
		theModel.addAttribute("employees", theEmployees);
		return "list-employees";
	}
	
}
