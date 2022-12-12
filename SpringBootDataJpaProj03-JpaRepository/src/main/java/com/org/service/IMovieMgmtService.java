package com.org.service;

import java.util.List;

import com.org.entity.Movie;

public interface IMovieMgmtService {
	
	public String removeMoviesByIds(List<Integer> ids);
	public List<Movie> searchMoviesByMovie(Movie movie, boolean asc, String... props);
	public Movie searchMovieById(Integer id);
	
}
