package com.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.org.sbeans.Hotel;

@SpringBootApplication
public class SpringBootProj04ValueAnnotationSpelApplication {

	public static void main(String[] args) {
		// Get IOC Container
		ApplicationContext ctx = SpringApplication.run(SpringBootProj04ValueAnnotationSpelApplication.class, args);
		
		//Get Hotel class object reference
		Hotel hotel = ctx.getBean("hotel", Hotel.class);
		
		System.out.println(hotel);
		
		// Close IOC Container 
		((ConfigurableApplicationContext) ctx).close();
	}

}
