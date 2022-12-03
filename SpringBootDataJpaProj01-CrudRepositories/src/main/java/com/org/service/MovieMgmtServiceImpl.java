package com.org.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.entity.Movie;
import com.org.repository.MovieRepo;

@Service("movieimpl")
public class MovieMgmtServiceImpl implements IMovieMgmtService {
	
	@Autowired
	private MovieRepo movierepo;
	
	@Override
	public String registerMovie(Movie movie) {
		
		System.out.println("InMemory Proxy class = "+movierepo.getClass()+"      "+Arrays.toString(movierepo.getClass().getInterfaces()));
		
		
		
		System.out.println("Movie before saving to DataBase "+movie);
		Movie movie1 = movierepo.save(movie);
		System.out.println("Movie After saving to DataBase "+movie1);
		
		return "Moie has been registered with the Id :"+movie1.getMid();
		
	}
	
	public long fetchNumberOfRecords() {
		return movierepo.count();
	}

	@Override
	public boolean checkById(Integer mid) {
		
		return movierepo.existsById(mid);
	}

	
	
	@Override
	public Iterable<Movie> fetchAllMovies() {
		System.out.println("\n===========Find All Moivies===========\n");
		
		return movierepo.findAll(); // Here we get all the records at once in list format cause findAll internally uses list
		
	}

	@Override
	public Iterable<Movie> fetchAllMoviesById(List<Integer> mids) {
		
		return movierepo.findAllById(mids);
	}

	@Override
	public Movie fetchMovieById(Integer mid) {
		
		Optional<Movie> opt = movierepo.findById(mid); 
		
		if(opt.isPresent())
			return opt.get();
		else
			throw new IllegalArgumentException("Record not Found");
		
	}
	
	
	/*
	@Override
	public Movie findMovieById(Integer mid) {
		
		return movierepo.findById(mid).orElseThrow(() -> new IllegalArgumentException("Record Not Found"));
		// If entity is available then it returns, If not it will raise an IllegalArgumentException
	}
	
	*/
	
	
	@Override
	public Movie findMovieById(Integer mid) {
		
		return movierepo.findById(mid).orElse(new Movie());  	 // If record is not there return empty movie object without raising the exception
	}
	
	public Optional<Movie> gatherMovieById(Integer mid){
		
		Optional<Movie> opt = movierepo.findById(mid);
		
//		if(opt.isEmpty())
//			return opt.empty();
//		else {
//			return opt;
//		}
		
		return opt.isEmpty()?Optional.empty():opt; // Efficient way of writing the code
	}
	

	
	//saveAll(-) to save bunch of entities

	@Override
	public String groupMovieRegistration(List<Movie> movieslist) {
		
		Iterable<Movie> savedmovies = movierepo.saveAll(movieslist);
		
		List<Integer> movielst = new ArrayList<Integer>();
		
		if(savedmovies != null && ((List<Movie>)savedmovies).size()>0)
		savedmovies.forEach(m -> {
			movielst.add(m.getMid());
		});
		
		return movielst.toString()+" Movies are saved";
	}
	
	
	// Partially updating the record by using save method
    // If no value is given other than Id then it will return as null
	
	
	@Override
	public String updateMovieDetails(Integer mid, String year, Float rating) {
		Optional<Movie> opt = movierepo.findById(mid);
		
		//Checking if the movie obj is present is or not
		if(opt.isPresent()) {
			Movie movie = opt.get();
			
			movie.setYear(year);
			movie.setRating(rating);
			
			// partially updating the record
			movierepo.save(movie);
			
			return movie.toString() +" Updtaed Successfully";
		} else {
			return "Movie Record not found with the id "+mid;
		}
	}
	
	// Complete obj updating the record by using save method
		
	                                   // Prefer this logic when we are not completely sure of the record is available
	                                   // If no value is given other than Id then it will return as null
	
	@Override
	public String updateMovieDetails(Movie movie) {
		
		Optional<Movie> opt  = movierepo.findById(movie.getMid());
		
		if(opt.isPresent()) {
			movierepo.save(movie);
			return movie.toString()+"Movie Record Updated sucessfully ";
		} else {
			return "Record not found for updation";
		}
		
	}
	

	
	/*
	@Override
	public String updateMovieDetails(Movie movie) {
		movierepo.save(movie);
		return "movie updated successfully";
	}
	  
	  // Prefer this logic when we are completely sure of the record is available
	   *  // If no value is given other than Id then it will return as null
	
	*/
	
	

	// Use this logic when we want to delete the record with by using id
	@Override
	public String removeMovieById(Integer id) {
		Movie movie = movierepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Record not found witht the matching Id"));
		
		movierepo.deleteById(movie.getMid());
		
		return "Record Deleted !";
		
	}
	
	
	
	// Use this logic when we are not sure of existing the obj data
	@Override
	public String removeMovie(Movie movie) {
		
		Optional<Movie> opt = movierepo.findById(movie.getMid());
		
		if(opt.isPresent()) {
			movierepo.delete(movie);
			return "Movie Deleted";
		}else {
			return "Record not found";
		}
	}
	
	
	
	/*
	 // Use this logic when we are sure of existing the obj data
	 
	 public String removeMovie(Movie movie) {
		movierepo.delete(movie);         
		return "Record Deleted";
	}
	*/ 
	
	
	
	public String removeAllMovies() {
		long count = movierepo.count();
		
		if(count != 0) {
			movierepo.deleteAll();
			
			return count+" Number of records are deleted";
		}
		
		return "No records found to delete";
	}
	
	
	@Override
	public String removeMoviesByListOfIds(List<Integer> deleteMoviesList) {
		 movierepo.deleteAllById(deleteMoviesList);
		return null;
	}
	
     
     
}
