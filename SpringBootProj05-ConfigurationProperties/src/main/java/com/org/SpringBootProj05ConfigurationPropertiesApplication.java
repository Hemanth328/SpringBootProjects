package com.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.org.sbeans.Company;

@SpringBootApplication
public class SpringBootProj05ConfigurationPropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootProj05ConfigurationPropertiesApplication.class, args);
		Company comp = ctx.getBean("company", Company.class);
		System.out.println(comp);
	}

}
