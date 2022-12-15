package com.org.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.org.entity.Movie;
import com.org.repository.MovieRepo;

@Component
public class QueryMethodTestRunnerForSingleRow implements CommandLineRunner {

	@Autowired
	private MovieRepo movieRepo;
	
	@Override
	public void run(String... args) throws Exception {
		/*	
			Movie movie = movieRepo.findMovieDataByMname("K L RAHUL");
			
			if(movie != null)
				System.out.println("Movie Details are "+movie);
			else
				System.out.println("Movie Details not found ");
			
		   System.out.println("\n=================================================\n");
		   
		   Object[] obj = (Object[]) movieRepo.fetchMoviePartialDataByMname("K L RAHUL");
		   for(Object val: obj) {
			   System.out.print(val+"  ");
		   }
		 
		   
		   System.out.println("\n=================================================\n");
		   
		   int mid = movieRepo.fetchMidOfMovieByMname("K L RAHUL");
		   System.out.println("Mid of the Given is  "+mid);
		   
		   */
	}

}
