package com.org.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.org.entity.Movie;
import com.org.service.IMovieMgmtService;

@Component
public class PagingAndSortingRepoTestRunner implements CommandLineRunner {
	
	@Autowired
	private IMovieMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("====================findAll(Sort sort)========================");
		
		/*
		try {
			Iterable<Movie> it = service.displayMoviesByOrder(false, "year", "mname");
			it.forEach(System.out::println);
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/
		
        System.out.println("\n====================findAll(Pageable pageable)========================\n");
		
		
		try {
			Page<Movie> page = service.generateReport(0, 4, false, "rating");
			
			System.out.println("Page Number "+page.getNumber());
			System.out.println("Page Count "+page.getTotalPages());
			System.out.println("First Page "+page.isFirst());
			System.out.println("Last Page "+page.isLast());
			System.out.println("Page Elements Count "+page.getNumberOfElements());
			
			if(!page.isEmpty()) {
				
				List<Movie> list = page.getContent();
				list.forEach(System.out::println);
			} else {
				System.out.println("No Record found in this page");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		 System.out.println("\n====================findAll(Pageable pageable) only by page size========================\n");
		 
		 
		try {
		   service.generateMoviesReport(5);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}