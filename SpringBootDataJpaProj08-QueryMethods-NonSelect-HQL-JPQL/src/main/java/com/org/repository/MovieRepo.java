package com.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.org.entity.Movie;


@Transactional  // Instead of applying on every method we can directly apply it on interface class level as well
public interface MovieRepo extends JpaRepository<Movie, Integer> {
	
	// Non Select queries generally return numeric value so we take return type as int
	
	@Query("update Movie set rating=:newRating where mname=:movieName")
	@Modifying
//	@Transactional
	public int modifyRatingByMovieName(String movieName, float newRating);
	
	
	@Query("delete from Movie where year>=:start and year<=:end")
	@Modifying
//	@Transactional
	public int deleteMoviesBy(String start, String end);
	
}
