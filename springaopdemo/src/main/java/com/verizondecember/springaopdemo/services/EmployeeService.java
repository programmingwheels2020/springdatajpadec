package com.verizondecember.springaopdemo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.verizondecember.springaopdemo.models.Employee;

@Service
public class EmployeeService {

	public List<Employee> getEmployees(){
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Lenin","IT"));
		return employees;
	}
	
	public Employee getEmployee(){
		
		return new Employee("Lenin","IT");
	}
}
