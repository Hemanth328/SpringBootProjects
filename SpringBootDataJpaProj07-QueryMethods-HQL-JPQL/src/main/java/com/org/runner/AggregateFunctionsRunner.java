package com.org.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.org.repository.MovieRepo;

@Component
public class AggregateFunctionsRunner implements CommandLineRunner {
	
	@Autowired
	private MovieRepo movieRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		System.out.println("\n---------------------------------------------------\n");
		
		float rating = movieRepo.fetchHighestRatingMovie();
		System.out.println("Highest Movie Rating "+ rating);
		
		
		System.out.println("\n---------------------------------------------------\n");
		
		Object[] obj = (Object[]) movieRepo.fetchAggregateDataOnMovies();
		System.out.println("Max Rating " +obj[0]);
		System.out.println("Min Rating " + obj[1]);
		System.out.println("AvgRating " + obj[2]);
		System.out.println("Count of Movies " + obj[3]);
//		System.out.println("Avg Of Years  " + obj[4]);   // In the new version of spring this is Invalid avg(string) can not be averaged
		System.out.println("Sum Of Years  " + obj[4]);
		
		
        System.out.println("\n---------------------------------------------------\n");
		
		movieRepo.fetchMaxRatingMovies().forEach(System.out::println);
		
		
	}

}
