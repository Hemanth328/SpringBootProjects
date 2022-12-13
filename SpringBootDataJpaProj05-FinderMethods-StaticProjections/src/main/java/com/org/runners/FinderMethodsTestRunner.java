package com.org.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.org.repository.MovieRepo;
import com.org.view.ResultView;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner {

	@Autowired
	private MovieRepo movieRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Repository Implementation class name "+movieRepo.getClass());
		
		Iterable<ResultView> lt = movieRepo.findByMidGreaterThanEqualAndMidLessThanEqual(1920, 2000);
		
		lt.forEach(view -> {
			System.out.println("Dynamic Model class name "+view.getClass());
			System.out.println(view.getMid()+"   "+view.getMname());
		});
	}

}
