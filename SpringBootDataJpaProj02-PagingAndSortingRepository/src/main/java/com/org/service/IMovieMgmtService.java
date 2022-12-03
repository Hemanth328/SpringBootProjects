package com.org.service;

import org.springframework.data.domain.Page;

import com.org.entity.Movie;

public interface IMovieMgmtService {
	
	// One method can have only one var arg param that too as last param of the method
	// var agrs are internally arrays
	public Iterable<Movie> displayMoviesByOrder(boolean asc, String...properties);
	
	public Page<Movie> generateReport(int pageNo, int pageSize, boolean asc, String...props);
	public void generateMoviesReport(int pageSize);
}
