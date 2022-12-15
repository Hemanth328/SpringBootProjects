package com.org.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.org.entity.Movie;
import com.org.repository.MovieRepo;
@Component
public class QueryMethodsTestRunner implements CommandLineRunner {

	@Autowired
	private MovieRepo movieRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*
		System.out.println("\n================ Query Methods Execution ======================\n");
		//		List<Movie> list = movieRepo.searchMoviesByIdRange(1900, 2000)
		 movieRepo.searchMoviesByIdRange(1900, 2000).forEach(System.out::println);
		 
		//	     movieRepo.searchMoviesByIdRange("Movie",1900, 2000).forEach(System.out::println); // invalid HQL query from MovieRepo
		 
		 System.out.println("\n==============================================\n");
		 movieRepo.searchMoviesByMnames("K L Rahul", "KGF", "EEGA").forEach(System.out::println);
		 
		 System.out.println("\n==============================================\n");
		 
		 movieRepo.fetchMovieDeatilsByRatingsAndYear(3.5f, "2004", "2008", "2022").forEach(row -> {
			 
			 for(Object val:row)
				 System.out.print(val+" ");
			 
			 System.out.println();
		 });
		 
		 System.out.println("\n==============================================\n");
		 
		 movieRepo.fetchMoviesByYearRange("2008", "2022").forEach(System.out::println);
		 
		 */
	     
	     
	}

}
