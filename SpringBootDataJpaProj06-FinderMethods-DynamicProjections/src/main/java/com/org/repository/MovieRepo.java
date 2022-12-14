package com.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.org.entity.Movie;
import com.org.view.View;


public interface MovieRepo extends JpaRepository<Movie, Integer> {
	
	public <T extends View> Iterable<T> findByMnameIn(List<String> movies, Class<T> clazz);
	
}
