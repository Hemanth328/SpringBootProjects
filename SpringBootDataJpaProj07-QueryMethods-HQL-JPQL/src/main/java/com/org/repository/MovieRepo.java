package com.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.org.entity.Movie;


public interface MovieRepo extends JpaRepository<Movie, Integer> {
	
	
	
	
	              // <------------------------- BULK OPERATIONS -------------------------->
	
	
//	@Query("from Movie where mid>=?1 and mid<=?2")  (OR)
//	@Query("from Movie as m  where m.mid>=?1 and m.mid<=?2")  (OR)
	/*@Query("from Movie where mid>=:min and mid<=:max")
	public List<Movie> searchMoviesByIdRange(@Param("min") int start, @Param("max") int end);*/
	
	         // (OR)
					
	@Query("from Movie where mid>=:min and mid<=:max") //  If the names of Named params in HQL/JPQL Query are matching with the names of java method params then we need not to
					                                   // place @Param annotation to map named params of query with method params For this we must ensure the settings of IDE as Well
	// This is a Entity Query				           // Right Click on the project --> click on java Compiler --> make sure that (Store Information about method Parameters (usable via reflection))
					                                   // check box is selected.
	public List<Movie> searchMoviesByIdRange(int min, int max);  // If we take same names as named parameters then we need not to annotate with @Param
			
	
	
	/*
	@Query("from Movie where mid>=?1 and mid<=:max")  // Can not use both positional and named parameters in single query
	public List<Movie> searchMoviesByIdRange(int min,int max);
	 
	@Query("from Movie where mid>=?1 and mid<=?3")  //Invalid because there must be no positional gap between ordinal params index
	
	@Query("from Movie where mid>=?0 and mid<=?1")  //Invalid because the ordinal param index should start with 1 only
	
	@Query("from Movie where mid>=?2 and mid<=?1")  // valid because ordinal positional param started with 1 and increment by 1, need not to bother about placement
	
	@Query("from Movie where mid>=?2 and mid<=?4")    //Invalid because the ordinal param index should start with 1 only
	
	@Query("from ?1 where mid>=?2 and mid<=?3")      //Invalid because we can not use Entity class name as the parameter value
	
	@Query("?1 Movie where mid>=?2 and mid<=?3")  //Invalid because we can not use HQL/JPQL keyword as the parameter value
	
	*/
	
	
	@Query("from Movie where mname in(:name1, :name2, :name3) order by mname asc")  // Executes Cause in the Query Methods the number of parameters should be same as named parameters
	public List<Movie> searchMoviesByMnames(String name1, String name2, String name3); 
	
	
//	@Query("from Movie where mname in(?1, ?2, ?3) order by mname asc")
//	public List<Movie> searchMoviesByMnames(String...  movies);  // Taking array/  var args/ collection params  
                                                                 //for multiple named params or positional params is not allowed this limitation is applied to the below condition 
	
	
	// ===============================Scalar Queries (Specific multiple col values) ============================
	
	@Query("select mid, mname, year from Movie where rating>=:rat and year in(:y1, :y2, :y3)")
	public List<Object[]> fetchMovieDeatilsByRatingsAndYear(Float rat, String y1, String y2, String y3);
	
	
	// ===============================Scalar Queries (Specific single col values) ============================
	
	@Query("select mname from Movie where year>=:start and year<=:end order by mname desc")
	public List<String> fetchMoviesByYearRange(String start, String end);
	
	
	
	
	// <------------------------- SINGLE ROW OPERATIONS -------------------------->
	
	
	// Single Row Entity Operation
	@Query("from Movie where mname=:name")  // value must be unique in the db table // When we are selecting all column values select is optional
	public Movie findMovieDataByMname(String name);
	
	
	// Single Row Scalar query giving specific multiple col values
	@Query(" select mid, mname, year from Movie where mname=:name")
	public Object fetchMoviePartialDataByMname(String name);

	
	
	// Single Row Scalar query giving specific single col value
	@Query(" select mid from Movie where mname=:name")
	public int fetchMidOfMovieByMname(String name);
	
	
	
	// <------------------------Single Aggregate Functions-------------------------------->
	
	@Query("select max(rating) from Movie")
	public float fetchHighestRatingMovie();
	
//	@Query("select max(rating), min(rating), avg(rating),count(*),avg(year), sum(year) from Movie") // In the new version of spring this is Invalid avg(string) can not be averaged
	@Query("select max(rating), min(rating), avg(rating),count(*), sum(year) from Movie")
	public Object fetchAggregateDataOnMovies();
	
	
	@Query(" from Movie where rating = (select max(rating) from Movie)")
	public List<Movie> fetchMaxRatingMovies();
	
	
}
