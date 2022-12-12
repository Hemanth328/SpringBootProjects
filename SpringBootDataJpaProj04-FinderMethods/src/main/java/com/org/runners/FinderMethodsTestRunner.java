package com.org.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.org.repository.MovieRepo;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner {

	@Autowired
	private MovieRepo movieRepo;  // InMemory proxy class object of our repository will be injected
	
	@Override
	public void run(String... args) throws Exception {
		
		// Finder Methods
		
		movieRepo.findByMnameEquals("rrR").forEach(System.out::println);
		
		System.out.println("\n=======================================\n");
		movieRepo.findByMnameIs("DON").forEach(System.out::println);
		
		System.out.println("\n=======================================\n");
		movieRepo.findBymname("DON").forEach(System.out::println);
		
		
		System.out.println("\n=======================================\n");
		movieRepo.findByMnameStartingWith("K").forEach(System.out::println);
		
		
		System.out.println("\n=======================================\n");
		movieRepo.findByMnameEndingWith("A").forEach(System.out::println);
		
		
		System.out.println("\n=======================================\n");
		movieRepo.findByMnameContaining("a").forEach(System.out::println);
		
		
		System.out.println("\n=======================================\n");
		movieRepo.findByMnameContaining("a").forEach(System.out::println);
		
		
		System.out.println("\n=======================================\n");
		movieRepo.findByMnameContaining("a").forEach(System.out::println);
		
		
		System.out.println("\n=======================================\n");
		movieRepo.findByMnameEqualsIgnoreCase("rrR").forEach(System.out::println);
		
		
		System.out.println("\n=======================================\n");
		movieRepo.findByMnameContainingIgnoreCase("ar").forEach(System.out::println);
		
		
		System.out.println("\n=======================================\n");
		movieRepo.findByMnameLike("R%").forEach(System.out::println);
		System.out.println("\n*******************************************\n");
		movieRepo.findByMnameLike("___").forEach(System.out::println);
		System.out.println("\n*******************************************\n");
		movieRepo.findByMnameLike("%R").forEach(System.out::println);
		System.out.println("\n*******************************************\n");
		movieRepo.findByMnameLike("%R%").forEach(System.out::println);
		
		
		
		System.out.println("\n=============== Finder Methods with Multiple condition properties===============\n");
		
		movieRepo.findByMidGreaterThanAndRatingLessThan(1652, 4.0f).forEach(System.out::println);
		System.out.println("\n#######################################\n");
		
		
		movieRepo.findByMnameStartingWithOrRatingBetween("R", 3.5f, 5.0f).forEach(System.out::println);
		System.out.println("\n#######################################\n");
		
		
		movieRepo.findByYearInOrMnameContainingIgnoreCaseAndRatingBetween(List.of("2021", "2022"), "r", 2.5f, 5.0f).forEach(System.out::println);
		System.out.println("\n#######################################\n");
		
		
		movieRepo.findByMnameNotLikeAndYearInOrderByMnameAsc("R%", List.of("2008", "2015")).forEach(System.out::println);
		System.out.println("\n");
		
		
	}

}
