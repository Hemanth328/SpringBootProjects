package com.org.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.org.entity.Movie;
import com.org.repository.MovieRepo;
import com.org.view.ResultView1;
import com.org.view.ResultView2;
import com.org.view.ResultView3;
@Component
public class FinderMethodsTestRunner implements CommandLineRunner {

	@Autowired
	private MovieRepo movieRepo;
	
	@Override
	public void run(String... args) throws Exception {
		/*	
			Iterable<ResultView1> list = movieRepo.findByMnameIn(List.of("RRR", "DON"), ResultView1.class);
			
			list.forEach(v1 -> System.out.println(v1.getMid()+"    "+v1.getMname()));
			
			System.out.println("\n=======================================================\n");
			
			movieRepo.findByMnameIn(List.of("K L Rahul", "DON"), ResultView2.class).forEach(v2 -> System.out.println(v2.getMid()+"   "+v2.getMname()+"   "+v2.getRating()));
			
			
			System.out.println("\n=======================================================\n");
			
			movieRepo.findByMnameIn(List.of("K L Rahul", "KGF"), ResultView3.class).forEach(v3 -> System.out.println(v3.getYear()));
			
		
			*/
		
		
		
		 // @Query Annotation
		
		Movie movie = new Movie();
		
		movie.setMname("ROBO");
		movie.setRating(4.1f);
		movie.setYear("2012");
		System.out.println(movieRepo.save(movie).getMid()+"  --- Object is saved");
		
	}

}
