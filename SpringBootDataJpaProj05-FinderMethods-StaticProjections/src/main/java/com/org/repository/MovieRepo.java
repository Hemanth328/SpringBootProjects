package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.org.entity.Movie;
import com.org.view.ResultView;


public interface MovieRepo extends JpaRepository<Movie, Integer> {
	
	public Iterable<ResultView> findByMidGreaterThanEqualAndMidLessThanEqual(int startMid, int endMid);
}
