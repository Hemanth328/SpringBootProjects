package com.org.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.org.entity.Movie;
import com.org.repository.MovieRepo;

@Component
public class NativeSQLTestRunner implements CommandLineRunner {

	@Autowired
	private MovieRepo movieRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
//		int result = movieRepo.registerMovie("Janatha Garage", 4.0f, "2016");
//		System.out.println(result!=0?"Movie Registered Successfully":"Movie Failed to Register");
		
		System.out.println("\n===========================================\n");
		
		System.out.println("Date and Time is  "+movieRepo.fetchSysDate());
		
		
		System.out.println("\n===========================================\n");
		
		int count = movieRepo.createTempTable();
		System.out.println(count == 0?"Table Created Successfully":"Table not created");
		// For Alter Queries if it is executed successfully it returns 0 else it returns -1
	}
}
