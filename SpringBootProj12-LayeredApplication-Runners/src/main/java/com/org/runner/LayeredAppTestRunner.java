package com.org.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.org.controller.PayrollOperationsController;
import com.org.model.Employee;

@Component
public class LayeredAppTestRunner implements CommandLineRunner {
	
	@Autowired
	private PayrollOperationsController payroll;

	@Override
	public void run(String... args) throws Exception {  // We need to call this method, by knowing the interface implementation automatically this method will be executed
		System.out.println("\nLayeredAppTestRunner.run()");
		
		 try {
	            List<Employee> list = payroll.showAllEmployeeByDesg("CLERK","MANAGER", "SALESMAN");

	            list.forEach(employee -> {
	                System.out.println(employee);
	            });

	        } catch (Exception e){
	            e.printStackTrace();
	        }

	}

}
