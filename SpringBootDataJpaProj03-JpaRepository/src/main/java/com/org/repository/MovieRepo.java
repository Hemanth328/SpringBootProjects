package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.org.entity.Movie;


public interface MovieRepo extends JpaRepository<Movie, Integer> {
  
}
