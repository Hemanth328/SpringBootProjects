package com.org.runners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.org.entity.Movie;
import com.org.service.IMovieMgmtService;

@Component
public class CrudReportTestRunner implements CommandLineRunner {
	
	@Autowired
	private IMovieMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		
		//Invoking Service Method
		Movie mov = new Movie();
		
		mov.setMname("KARTHEEKEYA 2");
		mov.setYear("2022");
		mov.setRating(4.8f);
		
		try {
//			System.out.println(service.registerMovie(movie));
			System.out.println(service.fetchNumberOfRecords());
//			System.out.println(service.checkById(952));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		System.out.println("*****************Find All Movies*******************");
		
		/*	
			
			try {
				
				Iterable<Movie> list = service.fetchAllMovies();
				
				for(Movie movie:list){  // enhanced for loop
					System.out.println(movie);
				}
				
				System.out.println("\n==========================\n");
				
				list.forEach(movie -> {  // for each method
					System.out.println(movie);
				});
				
				System.out.println("\n       For Each Method            \n");
				list.forEach(movie -> System.out.println(movie));
				
				System.out.println("\n   For Each Method + Static reference   \n");
				list.forEach(System.out::println);
				
				System.out.println("\n       For Each Method Streaming API Static MethodReference      \n");
				Arrays.asList(list).stream().forEach(System.out::println);
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
			*/
		
		
		
		System.out.println("\n-----------For FindAllByIds-------------\n");
		
		/*	
			
			try {
				List<Integer> idList = new ArrayList<Integer>();
				idList.add(152); idList.add(52);
				System.out.println("The list of Movies are "+service.fetchAllMoviesById(idList));
				System.out.println("The list of Movies are "+service.fetchAllMoviesById(List.of(152,202,203)));
				System.out.println("The list of Movies are "+service.fetchAllMoviesById(Arrays.asList(204,205,206)));
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			*/
		
		
		
		System.out.println("\n==================Optional Method findById==============================\n");
		
		
		/*
		try {
			System.out.println("Specified Id Record is   = "+service.fetchMovieById(209));
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		*/
		
		
			
			System.out.println("\n==========================Find By ID======================================\n");
			
			/*
			try {
				System.out.println(service.findMovieById(105));
			} catch(Exception e) {
				e.printStackTrace();
			}*/
		
		
		
		
		System.out.println("\n==========================Find Movie by using  Optional obj return ======================================\n");
		
		/*
		try {
			System.out.println(service.gatherMovieById(105));
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/
		
		
		System.out.println("\n==========================Saving all the Movies======================================\n");
		
		/*
		try {
			String result = service.groupMovieRegistration(List.of(new Movie("MAJOR", "2022", 5.0f),
					                                                new Movie("K L RAHUL", "2022", 5.0f),
					                                                new Movie("URI", "2022", 4.5f),
					                                                new Movie("KARTHEKEYA", "2022", 4.8f),
					                                                new Movie("AVATAR", "2014", 4.2f),
					                                                new Movie("PUSHPA", "2022", 4.6f),
					                                                new Movie("JUSTICE", "2008", 3.9f),
					                                                new Movie("KGF", "2022", 4.8f),
					                                                new Movie("ASURA", "2015", 3.3f),
					                                                new Movie("RRR", "2022", 4.4f),
					                                                new Movie("BHAGIRATHA", "2016", 3.8f),
					                                                new Movie("GAALODU", "2022", 3.8f),
					                                                new Movie("ROBO", "2012", 4.1f),
					                                                new Movie("MIRCHI", "2014", 4.2f),
					                                                new Movie("EEGA", "2014", 3.5f),
					                                                new Movie("SOFTWARESUDHEER", "2020", 2.8f)));
			System.out.println("List Of Movies = "+result);
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/
		
		
		System.out.println("\n=========================Partially opj Updating the record======================================\n");
	
		/*
		try {
			String result = service.updateMovieDetails(52, "2022", 4.2f);
			System.out.println("Updated Movie Details = "+result);
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/
			
		
		
       System.out.println("\n=========================Complete obj Updating the record======================================\n");
		/*
		try {
			Movie movie = new Movie("URI", "2019", 4.4f);
			movie.setMid(102);
			String result = service.updateMovieDetails(movie);
			System.out.println("Updated Movie Details = "+result);
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/
		
		
		/*
		System.out.println("\n=========================Delete Movie by Id======================================\n");
		
		try {
			System.out.println("Status = "+service.removeMovieById(254));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		*/
       System.out.println("\n=========================Delete Movie by object======================================\n");
		/*	
		try {
			Movie movie = new Movie("", "2022", 4.2f);
			movie.setMid(305);
			System.out.println("Object Deletion Status = "+service.removeMovie(movie));
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/
		
		
	     System.out.println("\n=========================Delete All Movies======================================\n");
		
			/*
			try {
			System.out.println(service.removeAllMovies());
			} catch(Exception e) {
				e.printStackTrace();
			}
			*/
		
	}

}