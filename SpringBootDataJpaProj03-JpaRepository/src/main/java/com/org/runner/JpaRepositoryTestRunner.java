package com.org.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.org.entity.Movie;
import com.org.service.IMovieMgmtService;

@Component
public class JpaRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private IMovieMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("\n=========================Delete Records in Batch==================================\n");

		/*
		try {
			
			List<Integer> ids = new ArrayList<Integer>(); // In List we can pass null and the query gets executed
			ids.add(2957);
			ids.add(null);
			ids.add(1964);
			
			
			List<Integer> ids = Arrays.asList(2956, null); // This will be executed, null is accepted as argument
			System.out.println(service.removeMoviesByIds(ids));
		//			System.out.println(service.removeMoviesByIds(List.of(1994,1996)));  // In the List.of() we can't pass null as an argument as it is immutable
			                                                                    // so it will throw an error as NullpointerException
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/

		System.out.println("\n========================= findAll(Example, Sort) method ==================================\n");

		try {
			Movie movie = new Movie();
			movie.setRating(4.2f);  
//			movie.setYear("2014");
			List<Movie> list = service.searchMoviesByMovie(movie, true, "rating");
			list.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		System.out.println("\n=========================Find Movie by Id==================================\n");

		try {
			Movie movie = service.searchMovieById(1953);
			
			System.out.println("Given Movie Details are "+service.searchMovieById(1953));
			System.out.println("Movie Object Class Name : "+movie.getClass());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
