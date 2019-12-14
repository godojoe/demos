package com.luv2code.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.cruddemo.entity.Employee;
import com.luv2code.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	@GetMapping("/employees")
	List<Employee> findAll() {
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeID}")
	Employee findById(@PathVariable int employeeID) {
		Employee theEmployee = employeeService.findById(employeeID);
		
		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found: " + employeeID);
		}
		
		return theEmployee;
	}
	
	@PostMapping("/employees")
	Employee save(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	@PutMapping("/employees")
	Employee updateEmployee(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);
		return theEmployee;
	}	
	
	@DeleteMapping("/employees/{employeeID}")
	String deleteEmployee(@PathVariable int employeeID) {
		Employee theEmployee = employeeService.findById(employeeID);
		
		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found: " + employeeID);
		}		
		
		employeeService.deleteById(employeeID);
		return "Employee deleted: " + employeeID;
	}		
}
