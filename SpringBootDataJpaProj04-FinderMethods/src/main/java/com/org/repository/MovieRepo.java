package com.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.org.entity.Movie;


public interface MovieRepo extends JpaRepository<Movie, Integer> {
	//Select mid, mname, year, ratings from Movie where movie name ='RRR'
	
	// List takes the SQL Query as Select *  so we will get all the columns of the record
	
	public List<Movie> findByMnameEquals(String name);  // With Generic returns Movie List
//	public List findByMnameEquals(String name);  // Without Generic returns only List
	public List<Movie> findByMnameIs(String name);
//	public List<Movie> findBymname(String name);
	public Iterable<Movie> findBymname(String name); // Performs same as above operation
	
	// Select mid, mname, year, ratings from Movie where mname like'R%'
	public Iterable<Movie> findByMnameStartingWith(String initChars);

	// Select mid, mname, year, ratings from Movie where mname like'%A'
	public Iterable<Movie> findByMnameEndingWith(String lastChars);
	
	
	// Select mid, mname, year, ratings from Movie where mname like'%HA'
	public Iterable<Movie> findByMnameContaining(String chars);
	
	
	// Select mid, mname, year, ratings from Movie where mname like'%HA'
	public Iterable<Movie> findByMnameEqualsIgnoreCase(String name);
	
	
	// Select mid, mname, year, ratings from Movie where mname like'%ar'
	public Iterable<Movie> findByMnameContainingIgnoreCase(String chars);
	
	//Select mid,mname,year,ratings from Movie where mname like 'R%'  movies starting with R
	//Select mid,mname,year,ratings from Movie where mname like '___'  3 letter movie
	//Select mid,mname,year,ratings from Movie where mname like '%R%'  Containing letter R
	//Select mid,mname,year,ratings from Movie where mname like '%R'  ending letter R
	public Iterable<Movie> findByMnameLike(String chars);
	
	
//	Finder methods with multiple properties based on conditions
	
	// Select mid, mname, year, ratings from Movie where mid>? and ratings<?
	public Iterable<Movie> findByMidGreaterThanAndRatingLessThan(int startMid, float endRatings);
	
	
	// Select mid, mname, year, ratings from Movie where Mname like 'R%' or (ratings between 3.0 and 5.0)
	public Iterable<Movie> findByMnameStartingWithOrRatingBetween(String mnameChars, float startRating, float endRatings);
	
	
	// Select mid, mname, year, ratings from Movie where year in (?, ?) or (upper(mname) like uppper(?) escape ?) and (ratings between ? and ? )
	public Iterable<Movie> findByYearInOrMnameContainingIgnoreCaseAndRatingBetween(List<String> years, String chars, float startRatings, float endRatings);
	
	
	// Select mid, mname, year, ratings from Movie where (mname not like ? escape ?) and (year in (?,?)) order by mname asc
	public Iterable<Movie> findByMnameNotLikeAndYearInOrderByMnameAsc(String letters, List<String> years);
	
}
