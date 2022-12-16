package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.org.entity.Movie;


@Transactional
public interface MovieRepo extends JpaRepository<Movie, Integer> {
	
	@Query(value = "INSERT INTO MOVIE_REPO VALUES(MOVIE_REPO_SEQ.NEXTVAL,?,?,?)", nativeQuery = true)
	@Modifying  // If we fail to write this annotation then every query will be taken as Select Query only
	public int registerMovie(String name, Float rating, String year);
	
	@Query(value = "SELECT SYSDATE FROM DUAL",nativeQuery = true)
//	@Modifying  // Modifying queries can only use void or int/Integer as return type; Offending method: public abstract java.lang.String com.org.repository.MovieRepo.fetchSysDate()
	public String fetchSysDate();
	
	
	@Query(value = "create table temp(col1 number(5))", nativeQuery = true)
	@Modifying
	public int createTempTable();
	
	
	
}
