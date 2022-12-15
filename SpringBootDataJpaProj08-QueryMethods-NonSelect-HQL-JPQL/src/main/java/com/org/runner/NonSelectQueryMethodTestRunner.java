package com.org.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.org.entity.Movie;
import com.org.repository.MovieRepo;

@Component
public class NonSelectQueryMethodTestRunner implements CommandLineRunner {

	@Autowired
	private MovieRepo movieRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("\n===============================================\n");
		
		int records = movieRepo.modifyRatingByMovieName("DON", 4.1f);
		System.out.println("Number of records updated are "+records);
		
		
		System.out.println("\n===============================================\n");

		int recordsDeleted = movieRepo.deleteMoviesBy("2018", "2020");
		System.out.println("Number of Movies  deleted  "+recordsDeleted);
	}

}
