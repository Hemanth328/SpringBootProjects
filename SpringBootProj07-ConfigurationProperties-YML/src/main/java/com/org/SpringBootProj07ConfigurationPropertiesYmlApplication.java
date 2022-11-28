package com.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.org.sbeans.Customer;

@SpringBootApplication
public class SpringBootProj07ConfigurationPropertiesYmlApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootProj07ConfigurationPropertiesYmlApplication.class, args);
		
		Customer cust = ctx.getBean("cust", Customer.class);
		System.out.println(cust);
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
