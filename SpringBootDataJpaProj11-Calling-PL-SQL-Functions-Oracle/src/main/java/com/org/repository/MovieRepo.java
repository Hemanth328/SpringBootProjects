package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.org.entity.Movie;


@Transactional
public interface MovieRepo extends JpaRepository<Movie, Integer> {
	
}
