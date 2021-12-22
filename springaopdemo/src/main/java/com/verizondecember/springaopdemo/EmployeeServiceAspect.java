package com.verizondecember.springaopdemo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceAspect {
	
	@Before(value="execution(* com.verizondecember.springaopdemo.services.EmployeeService.*(..))")
	public void logGetEmployeeFunction() {
		System.out.println("This is called when get* befor");
	}
	
	@After(value="execution(* com.verizondecember.springaopdemo.services.EmployeeService.get*(..))")
	public void logGetEmployeeFunctionDAfter() {
		System.out.println("This is called when get* After");
	}
	
	


}
