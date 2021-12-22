package com.verizondecember.springaopdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizondecember.springaopdemo.models.Employee;
import com.verizondecember.springaopdemo.services.EmployeeService;

@RestController
public class EmployeesController {

	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return empService.getEmployees();
	}
}
