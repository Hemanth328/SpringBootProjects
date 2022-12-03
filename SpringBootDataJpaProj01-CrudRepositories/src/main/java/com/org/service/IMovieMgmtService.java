package com.org.service;

import java.util.List;
import java.util.Optional;

import com.org.entity.Movie;

public interface IMovieMgmtService {
	public String registerMovie(Movie movie);
	
	public long fetchNumberOfRecords();
	
	public boolean checkById(Integer mid);
	
	public Iterable<Movie> fetchAllMovies();  // Iterable is a parent interface of collection Interface
	
	public Iterable<Movie> fetchAllMoviesById(List<Integer> mids);   // This method returns the record of movies for the given list of id's if exixts
	
	public Movie fetchMovieById(Integer mid);
	/*
	 * The return type is Optional<T> (Optional api) if there is a possibility of method returning no value or null  for failed conditions
	 * then we can return Optional<T> obj whith emptyness, so the receiving method need not to check null value and can avoid NullPointerException
	 * We can check the if the method returning is empty by using isEmpty() or isPresent() methods. 
	 */
	
	public Movie findMovieById(Integer mid);
	public Optional<Movie> gatherMovieById(Integer id);  // to return the optional Object
	
	public String groupMovieRegistration(List<Movie>  movieslist);
	
	public String updateMovieDetails(Integer mid, String year, Float rating);  // Partial Updation
	public String updateMovieDetails(Movie movie);   // complete updation
	
	public String removeMovieById(Integer id);
	public String removeMovie(Movie movie);
	
	public String removeAllMovies();
	public String removeMoviesByListOfIds(List<Integer> deleteMoviesList);
	  
}
