package com.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.org.sbeans.Employee;

@SpringBootApplication
public class SpringBootProj06ConfigurationPropertiesArayListSetHasApropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootProj06ConfigurationPropertiesArayListSetHasApropertiesApplication.class, args);
		
		Employee emp = ctx.getBean("employee", Employee.class);
		
		System.out.println(emp);
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
